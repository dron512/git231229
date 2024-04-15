package com.mh.mychart.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestClient testClient;

    @GetMapping("test")
    public String test(){
        String test = testClient.getTest();
        System.out.println(test);
        return "test";
    }
}
