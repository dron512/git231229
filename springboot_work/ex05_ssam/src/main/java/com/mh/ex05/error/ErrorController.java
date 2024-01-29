package com.mh.ex05.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ErrorController {

    @GetMapping("e401")
    public String e401(){
        return "error/e401";
    }

    @GetMapping("e404")
    public String e404(){
        return "error/e404";
    }

    @GetMapping("e500")
    public String e500(){
        return "error/e500";
    }
}
