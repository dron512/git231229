package com.pmh.firstservice.first;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("first-service")
@RequiredArgsConstructor
public class FirstController {

    private final Environment environment;

    @GetMapping("info")
    public String info(){
        return "info "+environment.getProperty("server.port");
    }
}
