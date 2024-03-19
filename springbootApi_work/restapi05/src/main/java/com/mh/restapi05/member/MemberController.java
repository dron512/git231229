package com.mh.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("")
    public List<Member> member() {
        List<Member> list = memberRepository.findAll();
        return list;
    }

    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {
        System.out.println(memberDto);
        return "member";
    }
}
