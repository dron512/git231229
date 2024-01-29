package com.mh.ex04.member;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("hi","hello");
        List<String> slist = Arrays.asList(
                "aaa","bbb","ccc"
        );
        model.addAttribute("slist",slist);

        List<Member> mlist = memberRepository.list();
        model.addAttribute("mlist",mlist);

        return "member/list";
    }

    @GetMapping("writeform")
    public String writeform(Model model, MemberReq memberReq){
        model.addAttribute("first","true");
        return "member/writeform";
    }

    @PostMapping("writeproc")
    public String writeproc(Model model, @Valid MemberReq memberReq, BindingResult result){
        System.out.println(memberReq);
        // 에러가 있으면 회원추가 하는 폼으로.. 종료
        if(result.hasErrors()){
            return "member/writeform";
        }

        // 회원 추가 시작
        Member member = Member.builder()
                        .email(memberReq.getEmail())
                        .password(memberReq.getPassword())
                        .gender(memberReq.getGender())
                        .build();

        String ret = memberService.insert(member);
        System.out.println(ret);
        model.addAttribute("ret",ret);
        if(ret.equals("duplicate")){
            return "member/writeform";
        }
        // 회원 추가 끝
        
        // 에러가 없으면 회원 목록 보는 주소로 이동
        return "redirect:/member/list";
    }


    @GetMapping("emailcheck")
    @ResponseBody
    public String emailcheck(String email){
        System.out.println(email);

        Member dbMember = memberRepository.findByEmail(email);

        if( dbMember !=null )
            return "fail";
        else{
            return "suc";
        }

    }
}








