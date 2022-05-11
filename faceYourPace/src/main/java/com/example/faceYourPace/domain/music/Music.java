package com.example.faceYourPace.domain.music;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter @Setter
public class Music {

    @Id
    @GeneratedValue
    @Column(name = "music_id")
    private Long id;

    //private String name; // 플레이리스트 이름

    private String musicName; // 음악 이름
    //private String artist; // 가수
    private Time musicStart; // 음악 시작 시간
    private Time musicEnd; // 음악 종료 시간
    private Integer musicRepeat; // 음악 반복 횟수

    private LocalDateTime createDate;

}
