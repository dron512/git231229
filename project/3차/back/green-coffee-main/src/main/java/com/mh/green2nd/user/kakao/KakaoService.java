//package com.mh.green2nd.user.kakao;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class KakaoService {
//
//    private final KakaoTokenClient kakaoTokenClient;
//    private final KakaoInfoClient kakaoInfoClient;
//
//    private String contentType = "Content-Type: application/x-www-form-urlencoded";
//
//    @Value("${kakao.client.id}")
//    private String clientId;
//
//    @Value("${kakao.client.secret}")
//    private String clientSecret;
//
//    @Value("${kakao.client.redirect}")
//    private String redirectUri;
//
//
//    public String getKakaoToken(String code){
//        KakaoTokenDto.Request kakaoTokenDtoRequest =
//                                KakaoTokenDto.Request.builder()
//                                    .grant_type("authorization_code")
//                                    .client_id(clientId)
//                                    .client_secret(clientSecret)
//                                    .redirect_uri(redirectUri)
//                                    .code(code)
//                                    .build();
//
//        KakaoTokenDto.Response resDto = kakaoTokenClient.getKakaoToken(contentType,kakaoTokenDtoRequest);
//        System.out.println(resDto.getAccess_token());
//
//        KakaoProfileDto kakaoProfileDto = kakaoInfoClient.getKakaoInfo("Bearer "+resDto.getAccess_token());
//        System.out.println(kakaoProfileDto);
//        /*
//
//        {
//        "id":3437435601,"connected_at":"2024-04-15T03:08:20Z",
//            "properties":{
//            "nickname":"헬로우",
//            "profile_image":"http://k.kakaocdn.net/dn/dhtMw8/btsDWsZxQIW/uQ3rsKSzTVdHE1mTsFTvkK/img_640x640.jpg",
//            "thumbnail_image":"http://k.kakaocdn.net/dn/dhtMw8/btsDWsZxQIW/uQ3rsKSzTVdHE1mTsFTvkK/img_110x110.jpg"
//           },
//        "kakao_account":
//            {"profile_nickname_needs_agreement":false,
//            "profile_image_needs_agreement":false,
//            "profile":
//            {
//                "nickname":"헬로우",
//                "thumbnail_image_url":"http://k.kakaocdn.net/dn/dhtMw8/btsDWsZxQIW/uQ3rsKSzTVdHE1mTsFTvkK/img_110x110.jpg",
//                "profile_image_url":"http://k.kakaocdn.net/dn/dhtMw8/btsDWsZxQIW/uQ3rsKSzTVdHE1mTsFTvkK/img_640x640.jpg",
//                "is_default_image":false,"is_default_nickname":false},
//                "has_email":true,
//                "email_needs_agreement":false,
//                "is_email_valid":true,
//                "is_email_verified":true,
//                "email":"mungsunsang@kakao.com"
//            }
//        }
//
//         */
//
//        return "getKakaoToken";
//    }
//}
