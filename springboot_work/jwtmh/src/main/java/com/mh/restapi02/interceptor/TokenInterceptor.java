package com.mh.restapi02.interceptor;

import com.mh.restapi02.jwt.ErrorCode;
import com.mh.restapi02.jwt.TokenException;
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
            throw new TokenException(ErrorCode.TOKEN_EXPIRED);
        }
        catch (Exception e){
            throw new TokenException(ErrorCode.TOKEN_VALID);
        }
        return true;
    }
}
