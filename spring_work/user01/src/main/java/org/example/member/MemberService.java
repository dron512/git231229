package org.example.member;

import java.time.LocalDate;
import java.util.Collection;

public class MemberService {

    //
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void regist(MemberDto md) {

        Member member = new Member(
                0,
                md.getEmail(),
                md.getName(),
                md.getPassword(),
                md.getConfirmPassword(),
                LocalDate.now()
        );

        memberRepository.insert(member);
    }

    public void list(){
        Collection<Member> collection = memberRepository.select();
        collection.stream()
                .forEach(System.out::println);

    }
}
