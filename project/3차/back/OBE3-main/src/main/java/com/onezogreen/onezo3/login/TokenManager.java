package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.hmacShaKeyFor;

@Component
public class TokenManager {

    @Value("${p3.jwt.secret}")
    private String mykey;
    //토큰 발급
    public String generateToken(ManagerVo managerVo){
        return Jwts.builder()
                .setSubject("onezo3Token")
                .claim("email",managerVo.getEmail())
                .claim("manager_id",managerVo.getManager_id())
                .claim("store_id",managerVo.getStore_id())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*15))
                .signWith(hmacShaKeyFor(mykey.getBytes()))
                .compact();
    }
    //토큰 검증
    public Jws<Claims> validateToken(String token){
        try{
            token=token.replaceAll("\\s","");

            SecretKey key= Keys.hmacShaKeyFor(mykey.getBytes(StandardCharsets.UTF_8));

            Jws<Claims> jws=Jwts.parser()
                    .setSigningKey(hmacShaKeyFor(mykey.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            System.out.println(jws);
            return jws;
        }catch (SignatureException se){
            se.printStackTrace();
            System.out.println("SignatureException="+se);
        }catch (ExpiredJwtException ee){
            ee.printStackTrace();
            System.out.println("ExpiredJwtException="+ee);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception="+e);
        }
        return null;
    }

}
