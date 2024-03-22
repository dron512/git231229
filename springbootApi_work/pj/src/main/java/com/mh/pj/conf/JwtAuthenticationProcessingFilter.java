package com.mh.pj.conf;

import com.mh.pj.jwt.ErrorCode;
import com.mh.pj.jwt.TokenException;
import com.mh.pj.jwt.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtAuthenticationProcessingFilter extends OncePerRequestFilter {

    private final TokenManager tokenManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        if(url.contains("/token") || url.contains("/h2-console")) {
            filterChain.doFilter(request, response);
            return;
        }
        String auth = request.getHeader("Authorization");
        if (auth == null || !auth.startsWith("Bearer ")) {
            System.out.println("No Bearer Token");
            throw new TokenException(ErrorCode.TOKEN_EXPIRED);
        }
        try {
            Jws<Claims> claimsJws = tokenManager.validateToken(auth.split("Bearer ")[1]);
            List<SimpleGrantedAuthority> roles = Stream.of(claimsJws.getPayload().get("role").toString())
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            Authentication authentication = UsernamePasswordAuthenticationToken
                    .authenticated(claimsJws.getPayload().get("username"),
                    null, roles);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (ExpiredJwtException e) {
            throw new TokenException(ErrorCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            throw new TokenException(ErrorCode.TOKEN_VALID);
        }
        filterChain.doFilter(request, response);
    }


}