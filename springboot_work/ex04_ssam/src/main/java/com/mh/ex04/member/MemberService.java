package com.mh.ex04.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public String insert(Member member){
        Member dbMember = memberRepository.findByEmail(member.getEmail());

        System.out.println(dbMember);
        if(dbMember==null) {
            memberRepository.insert(member);
            return "success";
        }else{
            return "duplicate";
        }
    }
}
