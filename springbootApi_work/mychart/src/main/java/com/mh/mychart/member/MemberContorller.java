package com.mh.mychart.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberContorller {

    private final MemberService memberService;

    @PostMapping("/new")
    public void newMember(@RequestBody Member member) {
        memberService.newMember(member);
    }
}
