package com.example.faceYourPace.repository;

import com.example.faceYourPace.domain.PlayList;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayListRepository {

    private final EntityManager em;

    public PlayListRepository(EntityManager em) {
        this.em = em;
    }

    public void save(PlayList playList) {
        em.persist(playList);
    }

    public PlayList findOne(Long id) {
        return em.find(PlayList.class, id);
    }

    public List<PlayList> findAllByString(PlayListSearch playListSearch) {

            String jpql = "select o from PlayList o join o.member m";
            boolean isFirstCondition = true;


        //회원 이름 검색
        if (StringUtils.hasText(playListSearch.getUserId())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.userId like :userId";
        }

        TypedQuery<PlayList> query = em.createQuery(jpql, PlayList.class)
                .setMaxResults(1000);

        if (StringUtils.hasText(playListSearch.getUserId())) {
            query = query.setParameter("userId", playListSearch.getUserId());
        }

        return query.getResultList();
    }

    /**
     * JPA Criteria
     */
    public List<PlayList> findAllByCriteria(PlayListSearch playListSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PlayList> cq = cb.createQuery(PlayList.class);
        Root<PlayList> o = cq.from(PlayList.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        //회원 이름 검색
        if (StringUtils.hasText(playListSearch.getUserId())) {
            Predicate name =
                    cb.like(m.<String>get("userId"), "%" + playListSearch.getUserId() + "%");
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<PlayList> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }

}

