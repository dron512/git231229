package project.team3.three.login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import project.team3.three.user.User;

import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${p3.jwt.secret}")
    private String mykey;

    // 토큰 발급해주는 함수
    public String generateToken(User user){
        return Jwts.builder()
                .subject("Project3Token")
                .claim("id", user.getUserId())
                .claim("username", user.getName())
                .claim("email", user.getEmail())
                // 유효시간 15분
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }

    // 토큰 검증해주는 함수
    public Jws<Claims> validateToken(String token){
        try{
            Jws<Claims> jws = Jwts.parser() // 번역해라
                    .setSigningKey(hmacShaKeyFor(mykey.getBytes())) // 비밀번호로
                    .build() // 객체 생성하고
                    .parseClaimsJws(token); // claim들을 번역해서 컬렉션 타입으로 만들어라


                    System.out.println(jws);
            return jws;
        }catch (SignatureException se){
            se.printStackTrace();
            System.out.println("SignatureException = " + se);
        }catch (ExpiredJwtException ee){
            ee.printStackTrace();
            System.out.println("ExpiredJwtException = " + ee);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception = " + e);
        }

        return null;

    }
}
