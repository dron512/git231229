package com.mh.restapi05.jwt;

import com.mh.restapi05.member.Member;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${mh.jwt.secret}")
    private String mykey;

    // 토큰 발급해주는 함수
    public String generateToken(Member member) {
        return Jwts.builder()
                .subject("mhToken")
                .claim("id", member.getId())
                .claim("username", member.getUsername())
                .claim("role", member.getRole())
                .claim("email", member.getEmail())
                // 유효시간은 1000 * 60 * 60 * 10 10시간
//                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                // 유효시간은 1000 * 60 * 15 15분
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    // 토큰 검증해주는 함수.
    public String validateToken(String token) {
        return null;
    }


}
