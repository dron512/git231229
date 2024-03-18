package com.mh.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String member() {
        return "member";
    }

    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {
        System.out.println(memberDto);
        return "member";
    }
}
