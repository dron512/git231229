package com.mh.ex05.member;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
        System.out.println("일로오나....");
        System.out.println(memberReq);

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

    @GetMapping("logout")
    public String logout(Authentication authentication, HttpServletRequest request){
        System.out.println(authentication);
        System.out.println(authentication.getPrincipal());
        // jsp 에서 session 안에 있는 모든 내용 삭제..
        request.getSession().invalidate();

        return "redirect:/";
    }

}
