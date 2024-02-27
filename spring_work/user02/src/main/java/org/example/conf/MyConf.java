package org.example.conf;

import org.example.component.AA;
import org.example.component.AABBService;
import org.example.member.MemberDAO;
import org.example.member.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.example.member","org.example.component"})
public class MyConf {

//    @Bean
//    @Qualifier("memberservice1")
//    public org.example.user.MemberService memberService1(){
//        return new org.example.user.MemberService();
//    }

//    @Bean
//    @Qualifier("memberservice2")
//    public org.example.member.MemberService memberService2(){
//        return new org.example.member.MemberService();
//    }

//    @Bean
//    public MemberDAO memberDAO() {
//        return new MemberDAO();
//    }

//    @Bean
//    public AABBService aabbService() {
//        return new AABBService();
//    }

    @Bean
    public AA aa(){
        return new AA();
    }

}
