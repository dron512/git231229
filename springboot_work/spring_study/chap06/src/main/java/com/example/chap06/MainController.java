package com.example.chap06;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("main")
    public String main(){
        return "MAIN";
    }

//    @PostMapping
//    @PutMapping
//    @DeleteMapping
}
