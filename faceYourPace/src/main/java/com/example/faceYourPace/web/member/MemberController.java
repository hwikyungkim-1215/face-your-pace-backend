package com.example.faceYourPace.web.member;

import com.example.faceYourPace.cmd.RecommandBpmPython;
import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.member.MemberService;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.domain.music.MusicForm;
import com.example.faceYourPace.repository.MemberRepository;
import com.example.faceYourPace.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final MusicRepository musicRepository;

    @GetMapping("/auth/signup")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new com.example.faceYourPace.web.member.MemberForm());
        return "회원가입 페이지";
    }

    @PostMapping("/auth/signup")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "false";
        }

        Member member = new Member();
        member.setUserId(form.getUserId());
        member.setUserPw(form.getUserPw());
        member.setUserName(form.getUserName());
        member.setUserEmail(form.getUserEmail());
        member.setUserAge(form.getUserAge());
        member.setUserHeight(form.getUserHeight());
        member.setUserWeight(form.getUserWeight());
        member.setCreateDate(LocalDateTime.now());
        member.setStride(form.getStride());
        member.setTarget_pace(form.getTarget_pace());
        member.setWorkout_level(form.getWorkout_level());

        memberService.join(member);
        return "true";
    }

    //@GetMapping("/api/mypage/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "회원 리스트";
    }

    @GetMapping("/api/mypage/members")
    List<Member> getAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/api/mypage/members/{userId}")
    List<Member> getUserIdAllDate(@PathVariable("userId") String userId) {
        return memberRepository.findByUserId(userId);
    }

    @GetMapping("auth/user/{userId}/edit")
    public String updateMemberForm(@PathVariable("memberId") Long memberId, Model model) {
        Member member = (Member) memberService.findOne(memberId);
        // update 안한 값들은 NULL로 저장되는 문제 해결할 것

        MemberForm form = new MemberForm();
        form.setUserName(member.getUserName());
        form.setUserEmail(member.getUserEmail());
        form.setUserAge(member.getUserAge());
        form.setUserHeight(member.getUserHeight());
        form.setUserWeight(member.getUserWeight());
        form.setStride(member.getStride());
        form.setTarget_pace(member.getTarget_pace());
        form.setWorkout_level(member.getWorkout_level());

        model.addAttribute("form", form);
        return "회원정보 update";
    }

    @PostMapping("auth/user/{memberId}/edit")
    public String updateMember(@PathVariable Long memberId, @ModelAttribute("form") Member member) {
        memberService.update(memberId, member);
        return "회원정보 update";
    }

    @PostMapping("/api/recommand/bpm/{userId}")
    public String recommandBpm(@PathVariable("userId") String userId){

        List<Member> members = memberService.findUserId(userId);

        String bpm = "null";

        for(Member member : members){
            if(member.getUserId().equals(userId)) {
                // bpm 추천
                bpm = RecommandBpmPython.create(member.getGender(), member.getUserAge(), member.getUserHeight(), member.getUserWeight(), member.getWorkout_level(), member.getTarget_pace(), member.getStride());
            }
        }

        System.out.println("bpm:" + bpm);
        return bpm;
    }

    @GetMapping("/api/music/list/{userId}") // 특정 userId의 music table 출력
    List<Music> getUserMusic(@PathVariable("userId") String userId) { // (해당 userId의) 음악리스트 출력(수정하기ㅠ)

        System.out.println("userId:" + userId);
        return musicRepository.findByUserId(userId);

    }



}
