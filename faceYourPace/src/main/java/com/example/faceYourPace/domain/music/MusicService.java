package com.example.faceYourPace.domain.music;

import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    @Transactional
    public Long join(Music music) { // 음악 등록
        musicRepository.save(music);
        return music.getId();
    }


    //음악 전체 조회
    public List<Music> findMusics() {
        return musicRepository.findAll();
    }

    public Music findOne(Long musicName) {
        return musicRepository.findOne(musicName);
    }

}