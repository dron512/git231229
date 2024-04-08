package com.mh.myorder.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/book")
    public String book(){
        return "book";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }
}
