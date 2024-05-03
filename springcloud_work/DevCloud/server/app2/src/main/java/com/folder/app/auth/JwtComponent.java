package com.folder.app.auth;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@RefreshScope
@Component
public class JwtComponent {

  @Value(value = "${jwt.key}")
  private String jwtKey;

  @Value(value = "${jwt.type}")
  private String jwtType;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private AuthMapper authMapper;

  public Map<String, Object> setJwtToken(String name) {
    Map<String, Object> resultMap = new HashMap<>();
    //User user = User.builder().name(name).build();
    User user = authMapper.findById(name);
    String token = Jwts.builder()
      .setClaims(createClaims(user))
      .signWith(getSignKey(), SignatureAlgorithm.HS256)
      .compact();
    resultMap.put("token", jwtType.concat(" ").concat(token));
    resultMap.put("state", true);
    return resultMap;
  }

  public Map<String, Object> getJwtInfo(HttpServletRequest request) {
    Map<String, Object> resultMap = new HashMap<>();
    String token = getTokenFromHeader(request);
    resultMap.put("header", getHeaderFromToken(token));
    resultMap.put("payload", getUserFromToken(token));
    resultMap.put("state", true);
    return resultMap;
  }

  private Key getSignKey() {
    byte[] keyBytes = Decoders.BASE64.decode(jwtKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  private Claims createClaims(User user) {
    Calendar date = Calendar.getInstance();
    date.add(Calendar.MINUTE, 3);
    return Jwts.claims()
      .setAudience(setContent(user))
      .setExpiration(date.getTime());
  }

  private String getTokenFromHeader(HttpServletRequest request) {
    String header = request.getHeader(HttpHeaders.AUTHORIZATION);
    String[] strArray = header.split(" ");
    if(jwtType.equals(strArray[0])) return strArray[1];
    return null;
  }

  private Map<String, Object> getHeaderFromToken(String token) {
    JwsHeader<?> jwsHeader = Jwts.parserBuilder()
      .setSigningKey(getSignKey()).build()
      .parseClaimsJws(token).getHeader();
    Map<String, Object> headeMap = new HashMap<>();
    headeMap.put("type", jwsHeader.getType());
    headeMap.put("algorithm", jwsHeader.getAlgorithm());
    return headeMap;
  }

  private User getUserFromToken(String token) {
    Claims claims = Jwts.parserBuilder()
      .setSigningKey(getSignKey()).build()
      .parseClaimsJws(token).getBody();
    User user = getContent(claims.getAudience());
    return user;
  }

  private String setContent(Object object) {
    try {
      return objectMapper.writeValueAsString(object);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return "";
  }

  private User getContent(String content) {
    try {
      return objectMapper.readValue(content, new TypeReference<User>() {});
    } catch(JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

}
