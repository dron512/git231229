package com.mh.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String member() {
        return "getMember";
    }

    // 1. db 저장하고 -> 유효성 검사를 하다가...
    // 2. security 추가
    // 3. 로그인할때 email password
    // 4. email password 로그인 해주는거

    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {

        log.info("ㅁㄴㅇㄹ???");
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);
        memberService.save(member);
        return "member";
    }
}
