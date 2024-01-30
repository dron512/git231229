package com.mh.ex05.addones;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("addones")
public class AddController {

    @GetMapping("charts")
    public String charts(){
        return "addones/charts";
    }

    @GetMapping("tables")
    public String tables(){
        return "addones/tables";
    }
}
