package com.mh.restapi05.member;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public String member(Authentication authentication) {
        Member member = (Member) authentication.getPrincipal();
        return "getMember email = "+member.getEmail()+
                        " : username : "+member.getUsername()+
                        " : role : "+member.getRole();
    }

    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {
        ModelMapper modelMapper = new ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);
        memberService.save(member);
        return "member";
    }
}
