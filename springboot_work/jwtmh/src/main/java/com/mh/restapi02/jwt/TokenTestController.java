package com.mh.restapi02.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenTestController {

    private final TokenManager tokenManager;
    @GetMapping("token")
    public String getToken(){
        String result = tokenManager.buildToken();
        return result;
    }

    @GetMapping("valid")
    public String getValid(){
        return "valid";
    }
}
