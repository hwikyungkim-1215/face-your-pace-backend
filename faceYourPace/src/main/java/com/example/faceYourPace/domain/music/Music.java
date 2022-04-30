package com.example.faceYourPace.domain.music;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Time;

@Entity
//@DiscriminatorValue("M")
@Getter
@Setter
public class Music extends Play {  // music < play

    private String musicName; // 음악 이름
    //private String artist; // 가수
    private Time musicStart; // 음악 시작 시간
    private Time musicEnd; // 음악 종료 시간
    private Integer musicRepeat; // 음악 반복 횟수


}
