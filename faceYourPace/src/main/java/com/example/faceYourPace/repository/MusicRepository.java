package com.example.faceYourPace.repository;

import com.example.faceYourPace.domain.music.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MusicRepository {

    private final EntityManager em;

    public void save(Music music) {
        if (music.getId() == null) {
            em.persist(music);
        } else {
            em.merge(music);
        }
    }

    public Music findOne(Long id) {
        return em.find(Music.class, id);
    }

    public List<Music> findAll() {
        return em.createQuery("select i from Music i", Music.class)
                .getResultList();
    }
}
