package com.mh.ex05.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
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
