package org.example;


import org.example.conf.MyConf;
import org.example.member.Member;
import org.example.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConf.class);

//        Member member1 = new Member(null,
//                            "aaa@naver.com",
//                           "5678",
//                          "김길동",
//                            LocalDateTime.now()
//        );
//
//        Member member2 = new Member(null,
//                "bbb@naver.com",
//                "1234",
//                "이길동",
//                LocalDateTime.now()
//        );


        Member member1 = Member.builder()
                .email("aaa@naver.com")
                .password("1234")
                .name("홍길동")
                .wdate(LocalDateTime.now())
                .build();

        Member member2 = Member.builder()
                .email("bbb@naver.com")
                .password("5678")
                .name("김길동")
                .wdate(LocalDateTime.now())
                .build();

        MemberService memberService = context.getBean(MemberService.class);
        memberService.Regist(member1);
        memberService.Regist(member2);

        memberService.list();

//        Member 두개

//        int[] arr = {10,20,30,40,50};
//
//        for (int temp :arr){
//            System.out.println(temp);
//        }
//
//        Arrays.stream(arr).forEach(System.out::println);
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter
//                = DateTimeFormatter.ofPattern("yyyy년MM월dd일 hh:mm:ss");
//
//        System.out.println(formatter.format(now));


        String[] str = context.getBeanDefinitionNames();

//        for (String temp : str){
//            System.out.println(temp);
//        }

        Arrays.stream(str).forEach(System.out::println);

        context.close();

    }
}