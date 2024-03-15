package com.mh.restapi03.login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("join")
    public String join(){
        return "join";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
