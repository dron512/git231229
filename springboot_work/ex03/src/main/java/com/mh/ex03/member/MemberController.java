package com.mh.ex03.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("list",memberService.list());
        return "member/list";
    }
}
