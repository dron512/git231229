package com.mh.mychart.member;

import com.mh.mychart.config.token.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TokenManager tokenManager;

    public String save(Member member) {
        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());

        if( optionalMember.isPresent()){
            return tokenManager.generateToken(optionalMember.get());
        }
        else {
            memberRepository.save(member);
            return tokenManager.generateToken(optionalMember.get());
        }
    }
}
