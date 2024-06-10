package com.mh.green2nd.homeAd;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/homeAd")
public class HomeAdController {

    private final HomeAdService homeAdService;

    // 로그인 시 환영 메시지
    @Operation(summary = "환영 메시지")
    @PostMapping("/welcome")
    public ResponseEntity<String> welcome() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) authentication.getPrincipal();
        String nickname = jwtUser.getNickname();
        return ResponseEntity.ok(nickname + "님 환영합니다!");
    }

    // 이벤트 홈 광고
    @Operation(summary = "이벤트 홈 광고")
    @GetMapping("/event")
    public ResponseEntity<List<HomeAd>> event() {
        return ResponseEntity.ok(homeAdService.getEvent());
    }

}
