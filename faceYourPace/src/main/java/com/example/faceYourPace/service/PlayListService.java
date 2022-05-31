package com.example.faceYourPace.service;

import com.example.faceYourPace.domain.PlayList;
import com.example.faceYourPace.domain.PlayListMusic;
import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.domain.music.MusicForm;
import com.example.faceYourPace.repository.MusicRepository;
import com.example.faceYourPace.repository.PlayListRepository;
import com.example.faceYourPace.repository.MemberRepository;
import com.example.faceYourPace.repository.PlayListSearch;
import com.example.faceYourPace.web.member.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayListService {

    private final PlayListRepository playListRepository;
    private final MemberRepository memberRepository;
    private final MusicRepository musicRepository;

    /**
     * 플레이리스트 추가
     */
    @Transactional
    public Long playList(Long memberId, String name) {

        //엔티티 조회
        Member member = memberRepository.findOne(memberId);

        //음악 생성
        //PlayListMusic playListMusic = PlayListMusic.createPlayListMusic(music);

        //플레이리스트 생성
        PlayList playList = PlayList.createPlayListNull(member, name);

        //플레이리스트 저장
        playListRepository.save(playList);

        //System.out.println("getId" + playList.getId());
        return playList.getId();
    }

    @Transactional
    public Long playList2(Long playListId, Long musicId) {

        //엔티티 조회
        //Member member = memberRepository.findOne(memberId);
        PlayList playList1 = playListRepository.findOne(playListId);
        Music music = musicRepository.findOne(musicId);

        //음악 생성
        PlayListMusic playListMusic = PlayListMusic.createPlayListMusic(music);


        //플레이리스트 생성
        PlayList playList = PlayList.createPlayList(playList1, playListMusic);

        //플레이리스트 저장
        playListRepository.save(playList);

        //System.out.println("getId" + playList.getId());
        return playList.getId();
    }


    public List<PlayList> findById(Long playListId) {

        return playListRepository.findById(playListId);
    }


    /**
     * 플레이리스트 삭제
     */
    @Transactional
    public void deletePlayList(Long playListId) {
        //주문 엔티티 조회
        PlayList playList = playListRepository.findOne(playListId);
        //주문 취소
        playList.delete();
    }

    //검색
    public List<PlayList> findPlayLists(PlayListSearch playListSearch) {
        return playListRepository.findAllByString(playListSearch);
    }
}
