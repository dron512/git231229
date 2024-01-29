package com.mh.ex05.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

    // select * from member where email = ?;
    public Member findByEmail(String email);
}
