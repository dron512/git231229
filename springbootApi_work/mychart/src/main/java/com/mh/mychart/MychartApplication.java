package com.mh.mychart;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.swing.text.html.parser.Entity;

@SpringBootApplication
@EnableFeignClients // FeignClient 사용을 위한 활성화
public class MychartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MychartApplication.class, args);
	}


	@Bean
	public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}

}
