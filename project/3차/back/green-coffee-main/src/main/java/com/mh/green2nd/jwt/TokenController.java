package com.mh.green2nd.jwt;

import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.security.Password;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    // 토큰 재발급
    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody Long userId) {
        String refreshToken = tokenManager.generateRefreshToken(userId);
        return ResponseEntity.ok(refreshToken);
    }

    // 토큰 검증
    @PostMapping("/token")
    public ResponseEntity<String> token(@RequestBody String refreshToken) {
        Jws<Claims> claims = tokenManager.validateToken(refreshToken);
        System.out.println(claims);

        Long userId = Long.parseLong(claims.getBody().getId());

        // Fetch the User object using userId
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String newAccessToken = tokenManager.generateToken(user);
            return ResponseEntity.ok(newAccessToken);
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

}
