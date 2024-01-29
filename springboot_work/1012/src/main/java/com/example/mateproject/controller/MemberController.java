package com.example.mateproject.controller;

import com.example.mateproject.dao.MemberRepository;
import com.example.mateproject.dao.StatusRepository;
import com.example.mateproject.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    StatusRepository statusRepository;


    @GetMapping("insert")
    @ResponseBody
    public String insert(Member member){
        System.out.println(member);
        memberRepository.doInsert(member);
        return "test";
    }


    @PostMapping("insert")
    public String pinsert(Member member){
        System.out.println(member);
        memberRepository.doInsert(member);
        return "redirect:/member/list";
    }

    @GetMapping("list")
    public String view(Model model){
//        Member dbMember = memberRepository.doSelectRow(member);
        model.addAttribute("member",memberRepository.doSelect());
//        model.addAttribute("member",memberRepository.doSelectByMemId());
        return "member/list";
    }


    @PostMapping("delete")
    @ResponseBody
    public String delete(Member member){
        memberRepository.doDelete(member);
        return "문자날아감";
    }





}
