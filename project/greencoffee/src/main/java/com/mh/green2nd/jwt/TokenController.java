package com.mh.green2nd.jwt;

import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import io.jsonwebtoken.security.Password;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final TokenManager tokenManager;
    private final UserRepository userRepository;

    //발급된 토큰 확인
//    @Operation(summary = "안씀 발행")
//    @PostMapping("/token")
//    public String token(@RequestBody TokenDto tokenDto) {
//        Optional<User> dbuser = userRepository.findByEmailAndPassword(
//                tokenDto.getEmail(),
//                tokenDto.getPassword());
//        if (dbuser.isEmpty()) {
//            throw new RuntimeException("회원가입이 안되어져있습니다.");
//        }
//        System.out.println("일로오나");
//        return tokenManager.generateToken(dbuser.get());
//    }
//
//
//    //토큰 유효성 확인
//    @Operation(summary = "검증 안함")
//    @GetMapping("/valid")
//    public String valid(HttpServletRequest request) {
//
//        String auth = request.getHeader("Authorization");
//        System.out.println(auth);
//
////        tokenManager.validateToken("eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtaFRva2VuIiwiaWQiOjEsInVzZXJuYW1lIjoi7ZmN6ri464-ZIiwicm9sZSI6IlVTRVIiLCJlbWFpbCI6ImFhYUBuYXZlci5jb20iLCJleHAiOjE3MTA5ODMzNjF9.JEIux5Tac-1pUFaRt8ByoDWJlENI9xo_j9LEL9aOaAJZxyNoaPJiYCgvl0Wnxi6S");
//
//        return "valid";
//    }

//    @GetMapping("auth")
//    public String loginTest(Authentication authentication) {
//        System.out.println(authentication);
//        System.out.println(authentication.isAuthenticated());
//        System.out.println(authentication.getPrincipal());
//        return "loginTest";
//    }

}
