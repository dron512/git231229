//package com.mh.green2nd.user.kakao;
//
//import lombok.Builder;
//import lombok.Getter;
//import lombok.ToString;
//
//public class KakaoTokenDto {
//
//    @Getter @Builder @ToString
//    public static class Request {
//        private String grant_type;
//        private String client_secret;
//        private String client_id;
//        private String redirect_uri;
//        private String code;
//    }
//
//    @Getter @Builder @ToString
//    public static class Response {
//        private String access_token;
//        private String token_type;
//        private String refresh_token;
//        private int expires_in;
//        private String scope;
//    }
//}
