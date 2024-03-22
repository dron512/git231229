package com.mh.pj.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenTestController {

    private final TokenManager tokenManager;
    @GetMapping("token")
    public String getToken(String username, String password){

        // todo...
        // username 과 password가 맞으면 토큰 발행
        String result = tokenManager.buildToken();
        return result;
    }

    @GetMapping("valid")
    public String getValid(){
        return "valid";
    }
}
