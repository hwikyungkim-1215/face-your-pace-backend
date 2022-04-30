package com.example.faceYourPace.domain.music;

import com.example.faceYourPace.domain.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Play { // item

    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private String name; // 플레이리스트 이름
    private Timestamp createDate;

   // private boolean isFile;


    @ManyToMany(mappedBy = "plays")
    private List<Category> categories = new ArrayList<>();

   /*
    public Play(String musicName, boolean isFile) {
        super();
        this.musicName = musicName;
        this.isFile = isFile;
    }


    public Play() {
        this.musicName = musicName;
        this.musicStart = musicStart;
        this.musicEnd = musicEnd;
        this.musicRepeat = musicRepeat;
        this.createDate = createDate;

    }


    public Play(String musicName, Time musicStart, Time musicEnd, int musicRepeat) {
        System.out.println("hello");

        this.musicName = musicName;
        this.musicStart = musicStart;
        this.musicEnd = musicEnd;
        this.musicRepeat = musicRepeat;


     //   String filepath = "/Users/hwikyung/Desktop/study/face-your-pace-backend/";
        //+ musicName+ "/";

        UUID uuid = UUID.randomUUID(); // uuid


    }

    */


}