package com.folder.gateway;

import java.net.InetAddress;
import java.net.URI;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class ApiFilter extends AbstractGatewayFilterFactory<ApiFilter.Config> {

  public static class Config {}

  public ApiFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {
      return (exchange, chain) -> {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        InetAddress address = request.getRemoteAddress().getAddress();
        URI uri = request.getURI();
        HttpStatusCode status = response.getStatusCode();


        log.info("[API 필터] 요청 -> IP : {}, PORT : {}, PATH : {}", address, uri.getPort(), uri.getPath());

        request.getHeaders().forEach( (key, value) -> {
          log.info("[요청 Header] {} : {}", key, value);
        });

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {

          log.info("[API 필터] 응답 -> URI : {}, 응답코드 : {}", uri, status);

          response.getHeaders().forEach( (key, value) -> {
            log.info("[응답 Header] {} : {}", key, value);
          });

        }));
      };
  }

}
