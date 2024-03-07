package org.example.studyspringbootsecurity.jwt.service;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.studyspringbootsecurity.domain.member.constant.Role;
import org.example.studyspringbootsecurity.error.AuthenticationException;
import org.example.studyspringbootsecurity.error.ErrorCode;
import org.example.studyspringbootsecurity.jwt.constant.GrantType;
import org.example.studyspringbootsecurity.jwt.constant.TokenType;
import org.example.studyspringbootsecurity.jwt.dto.JwtTokenDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenManager {

    @Value("${token.access-token-expiration-time}")
    private String accessTokenExpirationTime;
    @Value("${token.refresh-token-expiration-time}")
    private String refreshTokenExpirationTime;
    @Value("${token.secret}")
    private String tokenSecret;

    public JwtTokenDto createJwtTokenDto(Long memberId, Role role) {
        Date accessTokenExpireTime = createAccessTokenExpireTime();
        Date refreshTokenExpireTime = createRefreshTokenExpireTime();

        System.out.println(accessTokenExpirationTime);
        System.out.println(refreshTokenExpirationTime);
        String accessToken = null;
        String refreshToken = null;
        accessToken = createAccessToken(memberId, role, accessTokenExpireTime);
        refreshToken = createRefreshToken(memberId, refreshTokenExpireTime);
        System.out.println(accessToken);
        System.out.println(refreshToken);
        return JwtTokenDto.builder()
                .grantType(GrantType.BEARER.getType())
                .accessToken(accessToken)
                .accessTokenExpireTime(accessTokenExpireTime)
                .refreshToken(refreshToken)
                .refreshTokenExpireTime(refreshTokenExpireTime)
                .build();

    }

    public Date createAccessTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpirationTime));
    }

    public Date createRefreshTokenExpireTime() {
        return new Date(System.currentTimeMillis() + Long.parseLong(refreshTokenExpirationTime));
    }

    public String createAccessToken(Long memberId, Role role, Date expirationTime) {
        System.out.println(tokenSecret);
        System.out.println(expirationTime);

        String accessToken = Jwts.builder()
                .setSubject(TokenType.ACCESS.name())    // 토큰 제목
                .setIssuedAt(new Date())                // 토큰 발급 시간
                .setExpiration(expirationTime)          // 토큰 만료 시간
                .claim("memberId", memberId)      // 회원 아이디
                .claim("role", role)              // 유저 role
                .signWith(SignatureAlgorithm.HS256   , tokenSecret)
                .setHeaderParam("typ", "JWT")
                .compact();
        return accessToken;
    }

    public String createRefreshToken(Long memberId, Date expirationTime) {
        String refreshToken = Jwts.builder()
                .setSubject(TokenType.REFRESH.name())   // 토큰 제목
                .setIssuedAt(new Date())                // 토큰 발급 시간
                .setExpiration(expirationTime)          // 토큰 만료 시간
                .claim("memberId", memberId)      // 회원 아이디
                .signWith(SignatureAlgorithm.HS256, tokenSecret)
                .setHeaderParam("typ", "JWT")
                .compact();
        return refreshToken;
    }

    public void validateToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parser().setSigningKey(tokenSecret)
                    .build().parseSignedClaims(token);
        } catch (ExpiredJwtException e) {
            log.info("token 만료", e);
            throw new AuthenticationException(ErrorCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            log.info("유효하지 않은 token", e);
            throw new AuthenticationException(ErrorCode.NOT_VALID_TOKEN);
        }
    }

    public Claims getTokenClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(tokenSecret).build()
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.info("유효하지 않은 token", e);
            throw new AuthenticationException(ErrorCode.NOT_VALID_TOKEN);
        }
        return claims;
    }

}
