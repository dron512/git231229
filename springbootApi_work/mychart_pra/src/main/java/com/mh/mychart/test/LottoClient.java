package com.mh.mychart.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "lotto", url = "http://localhost:8080/test/v1/test")
public interface LottoClient {

    @GetMapping(value = "",consumes = "application/json")
    LottoDto getExample();
}
