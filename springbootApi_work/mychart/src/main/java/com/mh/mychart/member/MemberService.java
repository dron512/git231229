package com.mh.mychart.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void newMember(Member member) {
        memberRepository.save(member);
    }
}
