package com.three.alcoholshoppingmall.project.conf;

import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.login.token.TokenManager;
import com.three.alcoholshoppingmall.project.user.Gender;
import com.three.alcoholshoppingmall.project.user.User;
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

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.*;

@Component
@RequiredArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {

    private final TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (request.getRequestURI().contains("login") ||
                request.getRequestURI().contains("market") ||
                request.getRequestURI().contains("anony") ||
                request.getRequestURI().contains("kakao") ||
                request.getRequestURI().contains("images") ||
                request.getRequestURI().contains("swagger-ui") ||
                request.getRequestURI().contains("alcohol") ||
                request.getRequestURI().contains("imagesD") ||
                request.getRequestURI().contains("error") ||
                request.getRequestURI().contains("main/rand") ||
                request.getRequestURI().contains("main/newproduct") ||
                request.getRequestURI().contains("main/most") ||
                request.getRequestURI().contains("search/category") ||
//                request.getRequestURI().contains("user/withdraw") ||
                request.getRequestURI().contains("login/findEmail") ||
                request.getRequestURI().contains("detail") ||
                request.getRequestURI().contains("v3")) {
            return true;
        }

        if (token == null || !token.contains("Bearer ")) {
            System.out.println("토큰 없음");
            throw new BizException(NULLTOKEN);
//            return false;
        }
        try {
            Jws<Claims> jws = tokenManager.validateToken(token.substring("Bearer ".length()).trim());

            List<SimpleGrantedAuthority> roles =
                    Stream.of(jws.getPayload().get("email").toString())
                            .map(SimpleGrantedAuthority::new)
                            .toList();

            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(
                    User.builder()
                            .email(jws.getPayload().get("email").toString())
                            .nickname(jws.getPayload().get("nickname").toString())
                            .password(jws.getPayload().get("password").toString())
                            .address(jws.getPayload().get("address").toString())
                            .address2(jws.getPayload().get("address2").toString())
                            .gender(Gender.fromString(jws.getPayload().get("gender").toString()))
                            .birthdate(jws.getPayload().get("birthdate").toString())
                            .phone(jws.getPayload().get("phone").toString())
                            .id(jws.getPayload().get("id", Long.class))
                            .build(),
                    null,
                    roles);

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (ExpiredJwtException e) {
            System.out.println("토큰 만료");
            throw new BizException(JWTTOKENEXPIRTATION);
        } catch (Exception e) {
            System.out.println("토큰 검증 실패");
            throw new BizException(TOKENFAIL);
        }

        return true;
    }
}
