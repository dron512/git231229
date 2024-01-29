package com.pmh.ex01.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/hello")
    public String hello(
            // @RequestParam(value="name",required = false)
                        String name
//                        ,HttpServletRequest request
    ){
        System.out.println("name = "+ name);
//        String name = request.getParameter("name");
        return "hello";
    }
}
