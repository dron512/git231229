package org.example.studyspringbootsecurity.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.example.studyspringbootsecurity.domain.member.entity.Member;
import org.example.studyspringbootsecurity.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member registerMember(Member member) {
//        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

//    private void validateDuplicateMember(Member member) {
//        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());
//        if(optionalMember.isPresent()) {
//            throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
//        }
//    }

    @Transactional(readOnly = true)
    public Optional<Member> findMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

//    @Transactional(readOnly = true)
//    public Member findMemberByRefreshToken(String refreshToken) {
//        Member member = memberRepository.findByRefreshToken(refreshToken)
//                .orElseThrow(() -> new AuthenticationException(ErrorCode.REFRESH_TOKEN_NOT_FOUND));
//        LocalDateTime tokenExpirationTime = member.getTokenExpirationTime();
//        if(tokenExpirationTime.isBefore(LocalDateTime.now())) {
//            throw new AuthenticationException(ErrorCode.REFRESH_TOKEN_EXPIRED);
//        }
//        return member;
//    }

//    public Member findMemberByMemberId(Long memberId) {
//        return memberRepository.findById(memberId)
//                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_EXISTS));
//    }
}
