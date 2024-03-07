package org.example.studyspringbootsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudyspringbootsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyspringbootsecurityApplication.class, args);
    }

}
