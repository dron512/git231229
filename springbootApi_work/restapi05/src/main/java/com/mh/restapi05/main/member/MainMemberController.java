package com.mh.restapi05.main.member;

import com.mh.restapi05.member.Member;
import com.mh.restapi05.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("main")
@RequiredArgsConstructor
public class MainMemberController {

    private final MemberRepository memberRepository;

    @GetMapping("member")
    public String member(Model model){
        // select * from member;
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("list",memberList);

        List<String> list = Arrays.asList("111","222","333");
        model.addAttribute("stringlist",list);
        return "member/member";
    }
}
