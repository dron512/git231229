package com.mh.restapi03;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.Test;

public class MyEncrytor {

    //@Value("${jaspyt.encryptor.password}")
    private String password = "mh1234mh1234mh1234mh1234mh1234mh1234";

    @Test
    void name() {
        System.out.println("실행됩니다." + password);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);

        String content = "jdbc:mysql://112.218.211.194:3306/mh?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String encString = encryptor.encrypt(content);
        String decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));

        content = "root";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));

        content = "1234";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));
    }
}
