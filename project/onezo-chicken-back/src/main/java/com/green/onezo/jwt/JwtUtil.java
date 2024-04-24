package com.green.onezo.jwt;


import com.green.onezo.member.Member;
import com.green.onezo.member.MemberDTO;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;
import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;


@Component
public class JwtUtil {
    //application.yml에서 가져와야한다.
//    이거 오류 해결 하기 jasypt
    @Value("${spring.jwt.secret}")
    private String SECRET_KEY;

    //토큰에서 ID추출
    public String extractId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //토큰에서 만료시간 추출
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //토큰에서 클레임 추출
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //토큰에서 모든 클레임 추출
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

    //시크릿 키 생성
    private Key getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return hmacShaKeyFor(keyBytes);
    }

    //토큰이 만료되었는지 확인
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateRefreshToken(Member member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", member.getID());
        claims.put("name",member.getName());
        claims.put("phone",member.getPhone());
        claims.put("role", member.getRole());

        return createAccessToken(claims, "onezo");
    }

    //RefreshToken --> 한달
    private String createRefreshToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 31))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
    }

    //Access토큰 생성
    public String generateAccessToken(Member member) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", member.getID());
        claims.put("name",member.getName());
        claims.put("phone",member.getPhone());
        claims.put("role", member.getRole());

        return createAccessToken(claims, "onezo");
    }

    //AccessToken -->8시간
    private String createAccessToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                //토큰에 포함될 클레임(사용자 정보)를 설정
                .setClaims(claims)
                //JWT의 주제(Subject)를 설정
                .setSubject(subject)
                //JWT의 발급 시간을 설정, 현재 시간을 기준으로 설정
                .setIssuedAt(new Date(System.currentTimeMillis()))
                //JWT의 만료시간을 설정 현재 시간으로부터 8시간 후를 만료 시간으로 설정
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8))
                //JWT에 서명을 추가합니다. 시크릿 키와 HS256알고리즘을 사용하여 토큰을 서명
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                //설정이 완료된 JWT를 문자열로 직렬화하여 반환.
                .compact();


    }
  //  refresh토큰 검증
    public Jws<Claims> validateRefreshToken(String refreshToken){
        Jws<Claims> refreshjws=Jwts.parser()//번역
                .setSigningKey(hmacShaKeyFor(SECRET_KEY.getBytes()))//비밀번호로
                .build()//객체 생성 후
                .parseClaimsJws(refreshToken);//claim 들을 번역해줘 컬렉션타입으로
        System.out.println(refreshjws);
        return refreshjws;
    }
    //Access토큰 검증
    public Jws<Claims> validateAccessoken(String accessToken){
        Jws<Claims> acessjws=Jwts.parser()//번역
                .setSigningKey(hmacShaKeyFor(SECRET_KEY.getBytes()))//비밀번호로
                .build()//객체 생성 후
                .parseClaimsJws(accessToken);//claim 들을 번역해줘 컬렉션타입으로
        System.out.println(acessjws);
        return acessjws;
    }
}
