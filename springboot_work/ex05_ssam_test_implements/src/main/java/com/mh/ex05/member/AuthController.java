package com.mh.ex05.member;

import com.mh.ex05.email.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    EmailService emailService;

    @GetMapping("login")
    public String login(){
        return "auth/login";
    }

    @GetMapping("register")
    public String gregister(){
        return "auth/register";
    }

    @PostMapping("register")
    public String pregister(MemberReq memberReq){
        Member member = Member.builder()
                .email(memberReq.getEmail())
                .password(passwordEncoder.encode(memberReq.getPassword()))
                .build();

        memberRepository.save(member);

        return "redirect:/auth/login";
    }

    @GetMapping("password")
    public String password(){
        return "auth/password";
    }

    @PostMapping("password")
    public String ppassword(String email){

        // select * from member where email = 'email';
        Member dbMember = memberRepository.findByEmail(email);

        if(dbMember == null)
            throw new UsernameNotFoundException("해당하는 사용자가 없습니다.");

        // parkmyounghoi@gmail.com
        dbMember.setPassword(passwordEncoder.encode(email));
        // update 구문실행 update member set password = password where email = email;
        memberRepository.save(dbMember);

        // 사용자 없을시에 강제로 예외 발생
//        emailService.sendEmail(email,"비밀번호 초기화","비밀번호 초기화되었습니다.");
        return "auth/password";
    }

    @GetMapping("logout")
    public String logout(Authentication authentication, HttpServletRequest request){
        System.out.println(authentication);
        System.out.println(authentication.getPrincipal());
        // jsp 에서 session 안에 있는 모든 내용 삭제..
        request.getSession().invalidate();

        return "redirect:/";
    }

}
