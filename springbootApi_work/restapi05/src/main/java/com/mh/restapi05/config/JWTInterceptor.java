package com.mh.restapi05.config;

import com.mh.restapi05.jwt.TokenManager;
import com.mh.restapi05.member.Member;
import com.mh.restapi05.member.Role;
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
//        System.out.println("일로오나");
//        request.getHeaderNames().asIterator().forEachRemaining(System.out::println);
        String token = request.getHeader("Authorization");
        System.out.println(request.getRequestURI());
//        if(
//                request.getRequestURI().contains("swagger")
//                || request.getRequestURI().contains("file")
//                || request.getRequestURI().contains("error")
//                || request.getRequestURI().contains("common")
//                || request.getRequestURI().contains("main")
//                || request.getRequestURI().contains("h2")
//        )
//        {
//            return true;
//        }

        if(token == null || !token.startsWith("Bearer ")){
            System.out.println("token 이 없습니다.");
            return true;
        }
        else {
            try {
                Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()));

                List<SimpleGrantedAuthority> roles =
                        Stream.of(jws.getBody().get("role").toString())
                                .map(SimpleGrantedAuthority::new)
                                .toList();
                System.out.println(roles);

                // 로그인한 사람 정보를 Authentication에 저장해라..
                Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                        Member.builder()
                                .email(jws.getPayload().get("email").toString())
                                .username(jws.getPayload().get("username").toString())
                                .id(jws.getPayload().get("id", Long.class))
                                .role(
                                        Role.fromString(jws.getPayload().get("role").toString())
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
                throw new RuntimeException("JWT 토큰 검증 실패");
            }
            return true;
        }
    }
}
