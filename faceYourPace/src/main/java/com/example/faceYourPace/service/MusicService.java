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
    public void updateMusic(Long musicId, String musicStart, String musicEnd, String musicReqeat, String target_bpm) {
        Music music = musicRepository.findOne(musicId);
        music.setMusicStart(musicStart);
        music.setMusicEnd(musicEnd);
        music.setMusicRepeat(musicReqeat);
        music.setTarget_bpm(target_bpm);
    }

    @Transactional
    public void updateS3Title(Long musicId, String s3Title) {
        Music music = musicRepository.findOne(musicId);
        music.setS3Title(s3Title);
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

    /*
    public List<Music> findById(Long musicId) {
        return musicRepository.findById(musicId);
    }

     */

    public List<Music> findByMUserId(String userId) {
        return musicRepository.findByMUserId(userId);
    }

}
