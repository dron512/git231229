package com.git.ex03.member;

import com.git.ex03.component.AA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    AA aa;

    @GetMapping("aa")
    public String aa(Model model){
        System.out.println(aa);

        String a = "안녕하세요";
        model.addAttribute("hi",a);

        System.out.println(memberService);
        return "aa";
    }


    @GetMapping("regist")
    public String regist(){

        Member member = Member.builder()
                .email("aaa@naver.com")
                .password("1234")
                .localDate(LocalDate.now())
                .build();

        memberService.regist(member);

        return "regist";
    }

    @GetMapping("list")
    public String list(){

        memberService.list();

        return "list";
    }

}
