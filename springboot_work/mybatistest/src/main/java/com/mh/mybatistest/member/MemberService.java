package com.mh.mybatistest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public String save(Member member){
        memberRepository.insert(member);
        return "save success";
    }
}
