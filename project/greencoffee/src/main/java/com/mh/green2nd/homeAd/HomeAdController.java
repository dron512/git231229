// HomeAdController.java

package com.mh.green2nd.homeAd;

import com.mh.green2nd.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homeAd")
public class HomeAdController {

    @Autowired
    private HomeAdService homeAdService;

    // 로그인 시 환영 메시지
    @PostMapping("/welcome")
    public ResponseEntity<String> welcome() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User jwtUser = (User) authentication.getPrincipal();
        String nickname = jwtUser.getNickname();
        return ResponseEntity.ok(nickname + "님 환영합니다!");
    }

//    @GetMapping("/signupAd")
//    public ResponseEntity<List<HomeAdDTO>> getSignupAdvertisements() {
//        // 로그인 안 한 사용자에게만 보여주는 광고 가져오기
//        List<HomeAdDTO> advertisements = homeAdService.getAdvertisementsByCategory(HomeAdCategory.signupad);
//        return ResponseEntity.ok(advertisements);
//    }

    @GetMapping("/event")
    public ResponseEntity<List<HomeAdDTO>> getEventAdvertisements() {
        // 모든 사용자에게 보여주는 이벤트 광고 가져오기
        List<HomeAdDTO> advertisements = homeAdService.getAdvertisementsByCategory(HomeAdCategory.event);
        return ResponseEntity.ok(advertisements);
    }
}
