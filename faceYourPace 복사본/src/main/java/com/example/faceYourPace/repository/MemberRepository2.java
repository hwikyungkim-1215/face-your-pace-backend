package com.example.faceYourPace.repository;

import com.example.faceYourPace.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository2 extends JpaRepository<Member, Integer> {
    // JPA query method
    Member findByUserId(String userId); // userId로 찾기

}
