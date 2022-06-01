package com.example.faceYourPace.domain.login;

import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null 로그인 실패
     */
    public Member login(String userId, String userPw) {
        return memberRepository.findByUserId(userId)
                .stream().filter(m -> m.getUserPw().equals(userPw))
                .findAny().orElse(null);
    }

}
