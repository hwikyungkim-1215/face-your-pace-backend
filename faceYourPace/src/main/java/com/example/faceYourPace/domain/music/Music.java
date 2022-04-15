package com.example.faceYourPace.domain.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Music {

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private String musicName; // 음악 이름

    private Time musicStart; // 음악 시작 시간
    private Time musicEnd; // 음악 종료 시간
    private Integer musicRepeat; // 음악 반복 횟수

    private Timestamp createDate;

}