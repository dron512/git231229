package com.mh.ex04.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {

    public List<Member> list();
    public void insert(Member member);

    public Member findByEmail(String email);
}
