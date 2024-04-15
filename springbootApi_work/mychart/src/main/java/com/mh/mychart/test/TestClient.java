package com.mh.mychart.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "test", url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=861")
public interface TestClient {
    @GetMapping("")
    String getTest();
}
