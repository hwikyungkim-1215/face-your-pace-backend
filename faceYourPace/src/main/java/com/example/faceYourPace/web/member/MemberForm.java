package com.example.faceYourPace.web.member;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "아이디는 필수 입니다")
    private String userId; //로그인 ID

    @NotEmpty(message = "비밀번호는 필수 입니다")
    private String userPw; // 비밀번호

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String userName; //사용자 이름

    private String userEmail; //사용자 이메일

    private String userAge; // 나이
    private String userHeight; // 키
    private String userWeight; // 몸무게
}
