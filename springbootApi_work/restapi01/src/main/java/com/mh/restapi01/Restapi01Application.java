package com.mh.restapi01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Restapi01Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Restapi01Application.class, args);

		// controller service repository dto entity
		Arrays.stream(context.getBeanDefinitionNames())
				.filter(s -> s.contains("main"))
				.forEach(System.out::println);

	}

}
