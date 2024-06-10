package com.mh.green2nd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Green2ndApplication {

	public static void main(String[] args) {
		SpringApplication.run(Green2ndApplication.class, args);
	}

}
