package com.mh.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/auth")
    public String auth(Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        return "auth";
    }

    @GetMapping("")
    public List<Member> member() {
        List<Member> list = memberService.findAll();
        return list;
    }


    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {
        System.out.println(memberDto);
        return "member";
    }
}
