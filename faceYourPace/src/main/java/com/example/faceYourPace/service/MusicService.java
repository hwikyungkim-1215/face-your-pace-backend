package com.example.faceYourPace.service;

import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MusicService {

    private final MusicRepository musicRepository;

    @Transactional
    public void saveMusic(Music music) {

        musicRepository.save(music);
    }

    @Transactional
    public void updateMusic(Long musicId, String musicStart, String musicEnd, Integer musicReqeat) {
        Music music = musicRepository.findOne(musicId);
        music.setMusicStart(musicStart);
        music.setMusicEnd(musicEnd);
        music.setMusicRepeat(musicReqeat);
    }

    public List<Music> findMusics() {
        return musicRepository.findAll();
    }

    public Music findOne(Long musicId) {
        return musicRepository.findOne(musicId);
    }
    public Music findOne2(String musicName) {
        return musicRepository.findOne2(musicName);
    }


    public List<Music> findMusicName(String musicName) {
        return musicRepository.findByMusicName(musicName);
    }

    public List<Music> findById(Long musicId) {
        return musicRepository.findById(musicId);
    }

}
