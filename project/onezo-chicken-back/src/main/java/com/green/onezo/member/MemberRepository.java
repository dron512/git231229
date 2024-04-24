package com.green.onezo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

//    Optional<Member> findByEmail(String email);

//    Member findMemberByUser_id(Long id);

    Optional<Member> findByIDAndPassword(String ID, String password);

    Optional<Member> findByID(String ID);


}
