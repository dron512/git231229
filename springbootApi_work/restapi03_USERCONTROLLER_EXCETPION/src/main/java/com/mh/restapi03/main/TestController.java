package com.mh.restapi03.main;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 이것은 문서에 넣고 싶지 않아요...
    @GetMapping("test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }

}
