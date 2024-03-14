package com.mh.restapi03.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2")
public class VersionController2 {

    @GetMapping("hello")
    public String hello(){
        return "hello2";
    }


    /*
    v1/users -> UserController
    v2/users -> UserController2

    api/v1/hello -> hello1
    api/v2/hello -> hello2
     */
}
