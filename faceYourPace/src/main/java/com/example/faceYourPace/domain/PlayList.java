package com.example.faceYourPace.domain;

import com.example.faceYourPace.domain.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "playList")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayList { //playList

    @Id @GeneratedValue
    @JsonIgnore
    @Column(name = "playList_id")
    private Long id;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    private String name; // 플레이리스트 이름

    @JsonIgnore
    @OneToMany(mappedBy = "playList", cascade = CascadeType.ALL)
    private List<PlayListMusic> playListMusics = new ArrayList<>();


    private LocalDateTime playListDate; // 플레이리스트 생성 시간

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getPlayLists().add(this);
    }

    public void addPlayListMusic(PlayListMusic playListMusic) {
        playListMusics.add(playListMusic);
        playListMusic.setPlayList(this);
    }


    //==생성 메서드==//
    public static PlayList createPlayList(Member member, PlayListMusic... playListMusics) {
        PlayList playList = new PlayList();
        playList.setMember(member);
        for (PlayListMusic playListMusic : playListMusics) {
            playList.addPlayListMusic(playListMusic);
        }
        playList.setPlayListDate(LocalDateTime.now());
        return playList;
    }

    public static PlayList createPlayListNull(Member member, String name) {
        PlayList playList = new PlayList();
        playList.setMember(member);
        playList.setName(name);
        playList.setPlayListDate(LocalDateTime.now());
        return playList;
    }


    //==비즈니스 로직==//
    /**
     * 플레이리스트 삭제
     */
    public void delete() {

        for (PlayListMusic playListMusic : playListMusics) {
            playListMusic.delete();
        }
    }



}
