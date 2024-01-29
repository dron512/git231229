package com.mh.ex03.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Value("aa")
    private String aa;

    @Value("bb")
    private String asdfqwer;

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
