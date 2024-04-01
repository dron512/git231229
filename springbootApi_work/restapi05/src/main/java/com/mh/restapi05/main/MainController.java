package com.mh.restapi05.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    프론트 백엔드...
    @RestController -> UserEntity JSON {"key":"value", "key":"value"}

    @Controller -> layout/common
    templates / layout / common.html
 */

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("name", "홍길동");
        return "main";
    }

}









