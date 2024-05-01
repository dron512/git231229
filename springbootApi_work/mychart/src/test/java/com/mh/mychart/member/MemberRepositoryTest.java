package com.mh.mychart.member;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    @DisplayName("회원가입")
    void memberInsert() {
        // 회원가입
        // create
        // none 전략을 만들기...
//        for (int i=0; i<100;i++){
        // member 더미
//            memberRepository.save(Member.builder()
//                            .email("aaa"+i+"@naver.com")
//                            .nickname("aaa"+i)
//                    .build());
//        }
//        System.out.println("되나");
    }

    @Test
    @DisplayName("회원조회")
    void name() {
        QMember qMember = QMember.member;
        List<Member> list = jpaQueryFactory.selectFrom(qMember)
                .fetch();

        System.out.println(list);

        list.forEach(System.out::println);
    }

    @Test
    @DisplayName("회원조회NICKLIKEBooleanbuilder")
    public void memberFindALL(){
        QMember qMember = QMember.member;
//
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//        booleanBuilder.and(qMember.nickname.like("%9%"));
//
//        List<Member> memberList = memberRepository.findAll(booleanBuilder, PageRequest.of(0,5));
//        memberList.forEach(System.out::println);

        List<Member> member = jpaQueryFactory.selectFrom(qMember)
                .where(qMember.nickname.like("%9"))
                .offset(0)
                .limit(5)
                .fetch();

        member.forEach(System.out::println);

    }
}