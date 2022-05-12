package com.example.faceYourPace.domain.member;

import com.example.faceYourPace.domain.PlayList;
import com.example.faceYourPace.domain.music.Music;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    private String userId; //로그인 ID

    private String userPw; // 비밀번호

    private String userName; //사용자 이름

    private String userEmail; //사용자 이메일

    private String userAge; // 나이
    private String userHeight; // 키
    private String userWeight; // 몸무게

    private LocalDateTime createDate;


    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<PlayList> playLists = new ArrayList<>(); // orders

}
