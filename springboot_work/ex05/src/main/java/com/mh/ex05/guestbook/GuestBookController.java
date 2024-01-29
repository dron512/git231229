package com.mh.ex05.guestbook;

import com.mh.ex05.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("guestbook")
public class GuestBookController {

    @Autowired
    GuestBookRepository guestBookRepository;

    @GetMapping("test")
    @ResponseBody
    public String test(){
//        guestBookRepository.save(new GuestBook(1l,"홍길동"));
//        guestBookRepository.save(new GuestBook(2l,"이길동"));
        return "test";
    }

    @GetMapping("guestbook")
    public String guestbook(){
        return "guestbook/guestbook";
    }

    @PostMapping("save")
    @ResponseBody
    public String guestbook(@RequestBody GuestJson gj, Authentication authentication){
        System.out.println(((User)authentication.getPrincipal()).getUsername());
        System.out.println(gj);

        guestBookRepository.save(
                GuestBook.builder()
                        .content(gj.getContent())
                        .member(new Member(1l,"aa@naver.com","asdf"))
                        .build()
        );
        return "guestbook/guestbook";
    }
}
