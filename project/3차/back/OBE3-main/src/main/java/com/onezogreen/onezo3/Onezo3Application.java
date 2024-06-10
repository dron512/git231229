package com.onezogreen.onezo3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@OpenAPIDefinition(servers = {@Server(url = "https://admin.hellomh.site")})
@SpringBootApplication
@MapperScan("com.onezogreen.onezo3")
public class Onezo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Onezo3Application.class, args);
	}

}
