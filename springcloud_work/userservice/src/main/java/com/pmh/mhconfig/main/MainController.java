package com.pmh.mhconfig.main;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
@RequiredArgsConstructor
public class MainController {

    private final Environment env;

    @Value("${mh.value}")
    private String mhValue;

    @GetMapping("info")
    public String info(){
        String url = env.getProperty("spring.datasource.url");
        String mhvalue = env.getProperty("mh.value");
        return url+"\n"+mhvalue;
    }

}
