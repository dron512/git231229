//package com.mh.green2nd.user.kakao;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import com.mh.green2nd.user.User;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@ToString
//public class KakaoProfileDto {
//
//    private String id;
//
//    @JsonProperty("kakao_account")
//    private KakaoAccount kakaoAccount;
//
//    public User toUser() {
//        return User.builder()
////                .email(kakaoAccount.getEmail())
////                .nickname(kakaoAccount.getProfile().getNickname())
////                .profileImageUrl(kakaoAccount.getProfile().getProfileImageUrl())
////                .thumbnailImageUrl(kakaoAccount.getProfile().getThumbnailImageUrl())
////                .build();
//                .email(kakaoAccount.email)
//                .nickname(kakaoAccount.getProfile().getNickname())
//                .phone(kakaoAccount.phone)
//                .birthdate(this.kakaoAccount.birthdate)
//                .build();
//    }
//
//    @Getter
//    @Setter
//    @ToString
//    public static class KakaoAccount {
//        private String email;
//        private Profile profile;
//        private String phone;
//        private String birthdate;
//
//        @Getter
//        @Setter
//        @ToString
//        public static class Profile {
//            @JsonProperty("nickname")
//            private String nickname;
//
//            @JsonProperty("profile_image_url")
//            private String profileImageUrl;
//            @JsonProperty("thumbnail_image_url")
//            private String thumbnailImageUrl;
//        }
//    }
//
//}
