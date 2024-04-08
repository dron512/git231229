package com.mh.restapi05.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    프론트 백엔드...
    @RestController -> UserEntity JSON {"key":"value", "key":"value"}

    @Controller -> layout/common
    templates / layout / common.html
 */

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(value = "/main",method = {RequestMethod.GET, RequestMethod.POST})
    public String main(Model model){
        model.addAttribute("name", "홍길동");
        return "main";
    }

}









