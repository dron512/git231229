package com.mh.restapi05.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void init() {
        // 디비에 내용 다 삭제하기
        System.out.println("delete all");
        memberRepository.deleteAll();
    }

    @Test
    public void savetest() {
        Member member = Member.builder()
                .username("user")
                .password("1234")
                .email("aaa@naver.com").build();
        Member dbMember = memberRepository.save(member);
        // 맞는지 확인하는 작업
        assertEquals("user", dbMember.getUsername());
        assertEquals("1234", dbMember.getPassword());
    }
    @Test
    public void selectTest() {
        List<Member> list = memberRepository.findAll();

        for (Member member : list) {
            System.out.println(member);
        }
    }


}