package com.mh.mychart.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "example", url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber")
public interface ExampleClient {

    @GetMapping(value = "")
    String getExample(@RequestParam("drwNo") int drwNo);
}
