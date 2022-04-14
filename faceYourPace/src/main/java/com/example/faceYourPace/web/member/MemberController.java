package com.example.faceYourPace.web.member;

import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/auth/signup")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new com.example.faceYourPace.web.member.MemberForm());
        return "회원가입 페이지";
    }

    @PostMapping("/auth/signup")
    public String create(@Valid com.example.faceYourPace.web.member.MemberForm form, BindingResult result) {

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

        memberService.join(member);
        return "true";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "회원 리스트";
    }

}
