package com.example.faceYourPace.domain;

import com.example.faceYourPace.domain.music.Music;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlayListMusic {

    @Id @GeneratedValue
    @Column(name = "playList_music_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "music_id")
    private Music music;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "playList_id")
    private PlayList playList;

    //private String playListName; //플레이리스트 이름

    //==생성 메서드==//
    public static PlayListMusic createPlayListMusic(Music music) {
        PlayListMusic playListMusic = new PlayListMusic();
        playListMusic.setMusic(music);
        //playListMusic.setPlayListName(playListMusic.playListName);
        //playListMusic.setCount(count);

        //music.removeStock(count);
        return playListMusic;
    }


    //==비즈니스 로직==//
    public void delete() {


    }


}
