package com.mh.mychart.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestClient testClient;

    @GetMapping("test")
    public ResponseEntity<String> test(){
        System.out.println("일로오나");
                
        String test = testClient.getTest();
        System.out.println(test);

        return ResponseEntity.status(HttpStatus.OK).body(test);
    }
    
}
