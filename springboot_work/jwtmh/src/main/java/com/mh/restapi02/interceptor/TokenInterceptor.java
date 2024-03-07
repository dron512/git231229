package com.mh.restapi02.interceptor;

import com.mh.restapi02.jwt.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {
    private final TokenManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String auth = request.getHeader("Authorization");
        try {
            Jws<Claims> claimsJws = tokenManager.validateToken(auth.split("Bearer ")[1]);
            System.out.println(claimsJws);
        }catch (ExpiredJwtException e){
            System.out.println("토큰 만료");
        }
        catch (Exception e){
            System.out.println("토큰 에러");
            throw new Exception("에러");
        }
        return true;
    }
}
