package com.example.jjj.LoginSecond;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;

public class LoginSecondApplicaionTests {
	private String password = "abcd^^*^*";

	@Test
	void name() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setPoolSize(4);
		encryptor.setPassword(password);
		encryptor.setAlgorithm("PBEWithMD5AndTripleDES");

		String content = "jdbc:mysql://localhost:3306/onezo?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC";
		String encString = encryptor.encrypt(content);
		String decString = encryptor.decrypt(encString);
		System.out.println(String.format("url encString = %s decString = %s", encString,decString));

		content = "root";
		encString = encryptor.encrypt(content);
		decString = encryptor.decrypt(encString);
		System.out.println(String.format("root encString = %s decString = %s", encString,decString));

		content = "1234";
		encString = encryptor.encrypt(content);
		decString = encryptor.decrypt(encString);
		System.out.println(String.format("1234 encString = %s decString = %s", encString, decString));
	}
}