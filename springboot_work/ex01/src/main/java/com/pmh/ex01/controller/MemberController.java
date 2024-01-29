package com.pmh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
public class MemberController {

    @GetMapping("step1")
    public String step1(){
        return "member/step1";
    }

    @GetMapping("step2")
    public String step2(){
        return "member/step2";
    }

    @GetMapping("step3")
    public String step3(){
        return "member/step3";
    }
}
