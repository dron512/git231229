package com.mh.ex03.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    public List<MemberDto> list(){
        return memberRepository.list();
    }
}
