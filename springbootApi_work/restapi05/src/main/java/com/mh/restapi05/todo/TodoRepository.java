package com.mh.restapi05.todo;

import com.mh.restapi05.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findByMember(Member member);

    List<Todo> findAllByMember(Member member);
}
