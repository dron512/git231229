package com.mh.restapi02.conf;

import com.mh.restapi02.jwt.ErrorCode;
import com.mh.restapi02.jwt.TokenException;
import com.mh.restapi02.jwt.TokenManager;
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
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
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

        if(url.contains("/token")){
            filterChain.doFilter(request, response);
        }

        String auth = request.getHeader("Authorization");
        if (auth == null || !auth.startsWith("Bearer ")) {
            System.out.println("No Bearer Token");
            throw new TokenException(ErrorCode.TOKEN_EXPIRED);
        }

        try {
            Jws<Claims> claimsJws = tokenManager.validateToken(auth.split("Bearer ")[1]);
            System.out.println(claimsJws);

            List<SimpleGrantedAuthority> roles = Stream.of(claimsJws.getPayload().get("role").toString())
                    .map(SimpleGrantedAuthority::new)
                    .toList();

            Authentication authentication = UsernamePasswordAuthenticationToken.authenticated(claimsJws.getPayload().get("username"),
                    null, roles);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication.getAuthorities());
            System.out.println(authentication.getPrincipal());
        } catch (ExpiredJwtException e) {
            throw new TokenException(ErrorCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            throw new TokenException(ErrorCode.TOKEN_VALID);
        }

        filterChain.doFilter(request, response);
    }


}