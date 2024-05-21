package com.mh.green2nd.config;

import com.mh.green2nd.jwt.TokenManager;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {

    private final TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");
        System.out.println(request.getRequestURI());

        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("TOKEN이 없습니다.");
        } else {
            try {// 토크이 유효하면
                Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));

                List<SimpleGrantedAuthority> roles =
                        Stream.of(jws.getBody().get("role").toString())
                                .map(SimpleGrantedAuthority::new)
                                .toList();
                System.out.println(roles);

                // 로그인한 사람 정보를 Authentication에 저장해라..
                Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                        User.builder()
                                .user_id(Long.parseLong(jws.getPayload().get("user_id").toString()))
                                .email(jws.getPayload().get("email").toString())
                                .nickname(jws.getPayload().get("nickname").toString())
                                .role(
                                        Role.valueOf(Role.USER.toString())
                                )
                                .build(),
                        null,
                        roles
                );
                // 로그인한 사람 정보를 저장해라
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (ExpiredJwtException e) {
                System.out.println("토큰 만료");
                throw new RuntimeException("JWT 토큰 만료");
            } catch (Exception e) {
                System.out.println("토큰 검증 실패");
                e.printStackTrace();
                throw new RuntimeException("JWT 토큰 검증 실패");
            }
            return true;
        }
    }

}
