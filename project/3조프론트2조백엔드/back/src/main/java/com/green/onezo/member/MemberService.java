package com.green.onezo.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import com.green.onezo.enum_column.Role;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


//    private PasswordEncoder passwordEncoder;
    //회원가입 signUp
    @Transactional
    public Member signup(MemberDTO memberDTO) {

        Member member = new Member();
        member.setID(memberDTO.getID());
        member.setPassword(memberDTO.getPassword());//이거 암호화 진행 시켜야됨 jasypt 개놈새키
        member.setNickname(memberDTO.getNickname());
        member.setName(memberDTO.getName());
        member.setResign_yn(memberDTO.getResign_yn());
        member.setPhone(memberDTO.getPhone());
        //유저 권한을 부여.
        member.setRole(Role.USER);

        return memberRepository.save(member);
    }


    public Optional<Member> authenticate(String memberId, String password) {
        return memberRepository.findByIDAndPassword(memberId,password);
    }
}
