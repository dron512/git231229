//package com.mh.green2nd.user.kakao;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "kakaoinfo", url = "https://kapi.kakao.com")
//public interface KakaoInfoClient {
//
//    @PostMapping(value = "/v2/user/me", consumes = "application/json")
//    KakaoProfileDto getKakaoInfo(
//            @RequestHeader("Authorization") String accessToken);
//
//}
