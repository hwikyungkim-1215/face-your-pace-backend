package com.example.faceYourPace.repository;

import com.example.faceYourPace.domain.PlayList;
import com.example.faceYourPace.domain.member.Member;
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

    public Music findOne2(String musicName) {
        return em.find(Music.class, musicName);
    }

    public List<Music> findAll() {
        return em.createQuery("select i from Music i", Music.class)
                .getResultList();
    }

    public List<Music> findByMusicName(String musicName) {
        return em.createQuery("select m from Music m where m.musicName = :musicName", Music.class)
                .setParameter("musicName", musicName)
                .getResultList();
    }

    public List<Music> findByMUserId(String userId) {
        return em.createQuery("select m from Music m where m.mUserId = :userId", Music.class)
                //.setParameter("userId", userId)
                .getResultList();
    }


    public List<Music> findByMUserIdPlayList(String mUserId, String name) {
        return em.createQuery("select m from Music m" +
                        " where m.mUserId = ANY(select u.userId From Member u)", Music.class)
                //.setParameter("mUserId", mUserId)
                .getResultList();
    }

    /*
    public List<Music> findById22(String mUserId, String name) {
        return em.createQuery("select m from Music m" +
                        " where m.age > ANY(select u.age From User u)", Member.class)
                .setParameter("mUSerId", mUserId)
                .getResultList();
    }
    List<Music> anyQuery = em.createQuery
                    ("select m from Music m" +
                            " where m.mUserId = ANY(select u.userId From Member u)", Member.class)
            .getResultList();



     */

    public Music findMusicName(String musicName) {
        return em.find(Music.class, musicName);
    }
}
