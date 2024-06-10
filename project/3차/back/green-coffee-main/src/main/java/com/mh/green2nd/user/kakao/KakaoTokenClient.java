//package com.mh.green2nd.user.kakao;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.openfeign.SpringQueryMap;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "kakao", url ="https://kauth.kakao.com/oauth/token")
//public interface KakaoTokenClient {
//
//    @PostMapping(value = "",consumes = "application/json")
//    KakaoTokenDto.Response getKakaoToken(
//            @RequestHeader("Content-Type") String contentType,
//            @SpringQueryMap KakaoTokenDto.Request kakaoTokenDtoRequest);
//
//}
