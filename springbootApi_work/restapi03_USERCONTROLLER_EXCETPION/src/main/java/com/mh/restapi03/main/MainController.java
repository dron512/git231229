package com.mh.restapi03.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    @PostMapping("greet")
    public String greet(String param){
        return "greet "+param;
    }

}
