package com.folder.gateway;

import java.security.Key;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

  public static class Config {}

  public AuthFilter() {
    super(Config.class);
  }

  @Value(value = "${jwt.key}")
  private String jwtKey;

  private static final List<String> openApiEndpoints = List.of(
    "/auth/authorize",
    "/eureka"
  );

  private Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints
    .stream()
    .noneMatch(uri -> request.getURI().getPath().contains(uri));

  private void validateToken(String token) {
    Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
  }

  private Key getSignKey() {
      byte[] keyBytes = Decoders.BASE64.decode(jwtKey);
      return Keys.hmacShaKeyFor(keyBytes);
  }

  @Override
  public GatewayFilter apply(Config config) {
    return (exchange, chain) -> {
        ServerHttpResponse response = exchange.getResponse();
        if (isSecured.test(exchange.getRequest())) {
          if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
            log.info("요청 헤더에 Authorization 속성이 없습니다.");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
            //throw new RuntimeException("요청 헤더에 Authorization 속성이 없습니다.");
          }
          String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
          if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authHeader = authHeader.substring(7);
          }
          try {
            validateToken(authHeader);
          } catch (Exception e) {
            log.info("접근 권한이 없습니다.");
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return response.setComplete();
            //throw new RuntimeException("접근 권한이 없습니다.");
          }
        }
        return chain.filter(exchange);
      };
  }

}
