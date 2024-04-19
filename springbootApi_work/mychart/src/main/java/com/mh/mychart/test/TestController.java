package com.mh.mychart.test;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestClient testClient;

    @GetMapping("test")
    public ResponseEntity<String> test(@RequestHeader("Authorization") String auth){

        System.out.println(auth);

        String test = testClient.getTest();
        System.out.println(test);
        return ResponseEntity.status(HttpStatus.OK).body(test);
    }
}
