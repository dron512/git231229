package com.mh.ex03.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {
    List<MemberDto> list();
}
