package com.mh.mybatistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class MybatistestApplication {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(MybatistestApplication.class, args);

		String[] beans = context.getBeanDefinitionNames();

		Arrays.stream(beans).forEach(System.out::println);
	}

}
