package com.mh.mychart.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mh.mychart.member.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class KakaoProfileDto {

    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public Member toMember(){
        return Member.builder()
                .email(kakaoAccount.getEmail())
                .nickname(kakaoAccount.getProfile().getNickname())
                .profileImageUrl(kakaoAccount.getProfile().getProfileImageUrl())
                .thumbnailImageUrl(kakaoAccount.getProfile().getThumbnailImageUrl())
                .build();
    }

    @Getter @Setter @ToString
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Getter @Setter @ToString
        public static class Profile{
            @JsonProperty("nickname")
            private String nickname;

            @JsonProperty("profile_image_url")
            private String profileImageUrl;
            @JsonProperty("thumbnail_image_url")
            private String thumbnailImageUrl;
        }
    }

}
