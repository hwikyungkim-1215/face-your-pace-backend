package com.example.faceYourPace.domain.music;

import com.example.faceYourPace.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MusicRepository {

    private final EntityManager em;

    public void save(Music music) {
        em.persist(music);
    }

    public Music findOne(Long id) {
        return em.find(Music.class, id);
    }

    public List<Music> findAll() {
        return em.createQuery("select m from Music m", Music.class)
                .getResultList();
    }

    public List<Music> findByMusicId(String id) {
        return em.createQuery("select m from Music m where m.id = :id", Music.class)
                .setParameter("id", id)
                .getResultList();
    }
}
