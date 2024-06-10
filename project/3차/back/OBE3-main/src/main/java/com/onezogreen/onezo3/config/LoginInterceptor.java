package com.onezogreen.onezo3.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onezogreen.onezo3.login.TokenManager;
import com.onezogreen.onezo3.manager.ManagerVo;
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

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final TokenManager tokenManager;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        System.out.println(request.getRequestURI());

        if (request.getRequestURI().contains("error")
                || request.getRequestURI().contains("login")
                || request.getRequestURI().contains("findId")
                || request.getRequestURI().contains("findPw")
                || request.getRequestURI().contains("swagger")
                || request.getRequestURI().contains("v3/api-docs")
        ) {
            return true;
        }
        if (token == null || !token.startsWith("Bearer ")) {
            System.out.println("token is null");
            throw new RuntimeException("jwt 토큰 발행 후 진행하셈");
        }
        try {
            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer".length()));
            Claims payload = jws.getPayload();
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("jws:"+objectMapper.writeValueAsString(jws));

            List<SimpleGrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(jws.getPayload().get("email").toString()));
            System.out.println(roles);


            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                    ManagerVo.builder()
                            .email(jws.getPayload().get("email").toString())
                            .store_id(Long.parseLong(jws.getPayload().get("store_id").toString()))
                            .manager_id(Long.parseLong(jws.getPayload().get("manager_id").toString()))
                            .build(),
                    null,
                    roles
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (
                ExpiredJwtException e) {
            System.out.println("token is expired");
            throw new RuntimeException("jwt 만료");
        } catch (
                Exception e) {
            e.printStackTrace();
            System.out.println("토큰 검증 실패");
            throw new RuntimeException("jwt 토큰 검증 실패");
        }
        return true;
    }

}
