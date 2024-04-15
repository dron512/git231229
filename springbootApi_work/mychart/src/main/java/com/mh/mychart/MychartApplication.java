package com.mh.mychart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients // FeignClient 사용을 위한 활성화
public class MychartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MychartApplication.class, args);
	}

}
