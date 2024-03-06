package com.mh.restapi02.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenManager tokenManager;
    @GetMapping("token")
    public String getToken(){
        String result = tokenManager.buildToken();
        tokenManager.validateToken(result);
        return result;
    }
}
