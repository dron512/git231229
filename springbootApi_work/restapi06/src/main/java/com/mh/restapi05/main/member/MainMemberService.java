package com.mh.restapi05.main.member;

import com.mh.restapi05.member.Member;
import com.mh.restapi05.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// MainMemberService 클래스는 UserDetailsService 인터페이스를 구현합니다.
@RequiredArgsConstructor
@Service
public class MainMemberService implements UserDetailsService {

    // crud select insert update delete
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("일로오나"+email);

        Optional<Member> optionalMember= memberRepository.findByEmail(email);
        System.out.println("optionalMember"+optionalMember);
        if(optionalMember.isEmpty()){
            System.out.println("해당하는 사용자가 없습니다.");
        }

        Member member = optionalMember.get();

        // email 이 있고 비밀번호를 1234로 적었으면 로그인된다...
        // 세션이 만들어진다...
        /*
            aaa@naver.com 1234
            bbb@naver.com 5678 인데 암호화 되어서 $2a$10$du3NV69qls1qB/6pBVkW/umE7Kj4s/l04QBCs10mjYKDsq42NpvJK
         */
        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
