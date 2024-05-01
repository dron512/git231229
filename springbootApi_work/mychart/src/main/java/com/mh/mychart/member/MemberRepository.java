package com.mh.mychart.member;

import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    List<Member> findAll(BooleanBuilder booleanBuilder, PageRequest of);
}
