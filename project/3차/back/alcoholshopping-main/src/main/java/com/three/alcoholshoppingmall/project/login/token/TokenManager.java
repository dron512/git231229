package com.three.alcoholshoppingmall.project.login.token;

import com.three.alcoholshoppingmall.project.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${token.jwt.secret}")
    private String mykey;

    public String generateToken(User dbuser) {

        return Jwts.builder()
                .subject("loginToken")
                .claim("email", dbuser.getEmail())
                .claim("password", dbuser.getPassword())
                .claim("nickname", dbuser.getNickname())
                .claim("address", dbuser.getAddress())
                .claim("address2", dbuser.getAddress2())
                .claim("gender", dbuser.getGender())
                .claim("birthdate", dbuser.getBirthdate())
                .claim("phone", dbuser.getPhone())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 180))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    public Jws<Claims> validateToken(String token) {
        Jws<Claims> jws = Jwts.parser().setSigningKey(hmacShaKeyFor(mykey.getBytes()))
                .build()
                .parseClaimsJws(token);

        return jws;
    }
}
