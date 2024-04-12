package com.mh.mychart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MychartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MychartApplication.class, args);
	}

}
