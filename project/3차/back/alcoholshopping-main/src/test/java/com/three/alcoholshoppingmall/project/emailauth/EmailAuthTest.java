package com.three.alcoholshoppingmall.project.emailauth;


import com.three.alcoholshoppingmall.project.login.Email;
import com.three.alcoholshoppingmall.project.login.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EmailAuthTest {

    @Autowired
    private LoginController loginController;
    @Test
    void testEmailAuth(){
        Email email = Email.builder().email("gudtk789@naver.com").build();

        ResponseEntity<String> result = loginController.emailAuth(email);
        assertNotNull(result);
    }
}