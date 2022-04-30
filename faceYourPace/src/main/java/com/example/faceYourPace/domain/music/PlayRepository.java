package com.example.faceYourPace.domain.music;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayRepository {

    private final EntityManager em;

    public void save(Play play) {
        if (play.getId() == null) {
            em.persist(play);
        } else {
            em.merge(play);
        }
    }

    public Play findOne(Long id) {
        return em.find(Play.class, id);
    }

    public List<Play> findAll() {
        return em.createQuery("select m from Play m", Play.class)
                .getResultList();
    }

    public List<Play> findByMusicId(String id) {
        return em.createQuery("select m from Play m where m.id = :id", Play.class)
                .setParameter("id", id)
                .getResultList();
    }


}
