package com.mh.mychart.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void name() {
        // 회원가입
        // create
        // none 전략을 만들기...
        for (int i=0; i<100;i++){
        // member 더미
            memberRepository.save(Member.builder()
                            .email("aaa"+i+"@naver.com")
                            .nickname("aaa"+i)
                    .build());
        }
        System.out.println("되나");

    }
}