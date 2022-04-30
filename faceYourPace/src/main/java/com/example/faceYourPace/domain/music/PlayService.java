package com.example.faceYourPace.domain.music;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayService {

    private final PlayRepository playRepository;

    @Transactional
    public void savePlay(Play play) {
        playRepository.save(play);
    }

    @Transactional
    public void updatePlay(Long id,String name, Timestamp createDate) {
        Play play = playRepository.findOne(id);
        play.setName(name);
        play.setCreateDate(createDate);
    }


    public List<Play> findPlays() {
        return playRepository.findAll();
    }

    public Play findOne(Long itemId) {
        return playRepository.findOne(itemId);
    }


}