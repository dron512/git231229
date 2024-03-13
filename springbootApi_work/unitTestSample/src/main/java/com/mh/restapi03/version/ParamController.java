package com.mh.restapi03.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ParamController {

    @GetMapping(value = "param",params = "v1=1")
    public String paramV1(){
        return "paramV1";
    }
    @GetMapping(value = "param",params = "v1=2")
    public String paramV2(){
        return "paramV2";
    }
}
