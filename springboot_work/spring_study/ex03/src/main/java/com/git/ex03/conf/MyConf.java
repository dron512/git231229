package com.git.ex03.conf;

import com.git.ex03.member.MemberRepository;
import com.git.ex03.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    memberController
    memberService
    memberRepository
    Member

    regist ->
    list ->
*/
@Configuration
public class MyConf {

    @Bean
    public MemberService memberService(){
        return new MemberService();
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepository();
    }

}
