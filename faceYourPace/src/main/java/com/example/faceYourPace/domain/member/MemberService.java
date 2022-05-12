package com.example.faceYourPace.domain.member;

import com.example.faceYourPace.repository.MemberRepository;
import com.example.faceYourPace.web.member.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member) { // 회원가입

        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //중복 회원 검증
        List<Member> findMembers = memberRepository.findByUserId(member.getUserId());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    /**
     * 회원 수정
     */

    /*
    @Transactional
    public void update(Long id, String userName, String userEmail, String userAge, String userHeight, String userWeight) {
        Member member = memberRepository.findOne(id);
        member.setUserName(userName);
        member.setUserAge(userAge);
        member.setUserEmail(userEmail);
        member.setUserHeight(userHeight);
        member.setUserWeight(userWeight);
    }

     */
    @Transactional
    public Member update(Long id, Member member) {
        // 1. 영속화
        // 1. 무조건 찾았다. 걱정마 get() 2. 못찾았어 익섹션 발동시킬께 orElseThrow()
        Member userEntity = memberRepository.findOne(id);

        // 2. 영속화된 오브젝트를 수정 - 더티체킹 (업데이트 완료)
        userEntity.setUserId(member.getUserId());

        userEntity.setUserName(member.getUserName());
        userEntity.setUserEmail(member.getUserEmail());
        userEntity.setUserAge(member.getUserAge());
        userEntity.setUserWeight(member.getUserWeight());
        userEntity.setUserHeight(member.getUserHeight());

        return userEntity;
    } // 더티체킹이 일어나서 업데이트가 완료됨.



}
