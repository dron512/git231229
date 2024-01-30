package com.mh.ex05.main;

import com.mh.ex05.member.Member;
import com.mh.ex05.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Member> list = memberRepository.findAll();
        model.addAttribute("list",list);
        System.out.println(list);
        return "index";
    }

    @GetMapping("staticnavigation")
    public String staticnavigation(){
        return "layout-static";
    }

    @GetMapping("lightsidenav")
    public String lightsidenav(){
        return "layout-sidenav-light";
    }

}
