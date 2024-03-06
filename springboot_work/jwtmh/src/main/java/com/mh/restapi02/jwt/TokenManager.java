package com.mh.restapi02.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenManager {

    @Value("${spring.jwt.secret}")
    private String mykey;

    public String buildToken(){
        return Jwts.builder()
                .subject("token")
                .expiration(createTokenExpiration())
                .claim("memberId","member1")
                .claim("role","User")
                .signWith(Keys
                        .hmacShaKeyFor(Base64.getEncoder().encode(mykey.getBytes(StandardCharsets.UTF_8))))
                .compact();
    }

    public void validateToken(String token){
        try{
            Jws<Claims> claimsJws = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(Base64.getEncoder().encode(mykey.getBytes(StandardCharsets.UTF_8))))
                    .build()
                    .parseSignedClaims(token);

            System.out.println(claimsJws);
        }catch (ExpiredJwtException e){
            System.out.println("토큰만료");
        }catch (Exception e){
            System.out.println("유효하지 않은 토큰");
        }

    }

    private Date createTokenExpiration(){
        return new Date(System.currentTimeMillis()+1000*60*15);
    }
}
