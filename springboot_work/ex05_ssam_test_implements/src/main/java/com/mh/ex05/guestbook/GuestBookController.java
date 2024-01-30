package com.mh.ex05.guestbook;

import com.mh.ex05.member.Member;
import com.mh.ex05.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("guestbook")
public class GuestBookController {

    @Autowired
    GuestBookRepository guestBookRepository;

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("test")
    @ResponseBody
    public String test(){
//        guestBookRepository.save(new GuestBook(1l,"홍길동"));
//        guestBookRepository.save(new GuestBook(2l,"이길동"));
        return "test";
    }

    @GetMapping("guestbook")
    public String guestbook(Model model){

        List<GuestBook> list = guestBookRepository.findAll(Sort.by(Sort.Direction.DESC,"idx"));

        model.addAttribute("list",list);
        return "guestbook/guestbook";
    }

    @PostMapping("save")
    @ResponseBody
    public String guestbook(@RequestBody GuestJson gj, Authentication authentication){
        String email = ((User)authentication.getPrincipal()).getUsername();

        Member dbmember = memberRepository.findByEmail(email);

        guestBookRepository.save(
                GuestBook.builder()
                        .content(gj.getContent())
                        .member(dbmember)
                        .build()
        );

        return email;
    }
}
