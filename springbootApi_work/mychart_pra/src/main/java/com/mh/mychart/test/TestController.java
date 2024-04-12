package com.mh.mychart.test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RequiredArgsConstructor
@RestController
public class TestController {

    private final ExampleClient exampleClient;
    private final LottoClient lottoClient;

    @GetMapping("/test")
    public ResponseEntity<String> test(){

        String test = exampleClient.getExample(816);
        System.out.println(test);
        return ResponseEntity.ok("test");
    }

    @GetMapping("/v1/test")
    public ResponseEntity<LottoDto> testV1(){
        return ResponseEntity.ok(new LottoDto());
    }

    @GetMapping("/v2/test")
    public ResponseEntity<String> testV2(){
        LottoDto lottoDto = lottoClient.getExample();
        return ResponseEntity.ok("test");
    }
}
