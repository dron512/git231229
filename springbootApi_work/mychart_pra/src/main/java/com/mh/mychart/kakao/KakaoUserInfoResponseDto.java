package com.mh.mychart.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mh.mychart.member.Member;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class KakaoUserInfoResponseDto {

    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public Member toEntity() {
        Member member = Member.builder()
                .email(kakaoAccount.getEmail())
                .username(kakaoAccount.getProfile().getNickname())
                .profileImageUrl(kakaoAccount.getProfile().getThumbnailImageUrl())
                .build();
        return member;
    }

    @Getter @Setter
    public static class KakaoAccount {
        private String email;
        private Profile profile;

        @Getter @Setter
        public static class Profile {

            private String nickname;

            @JsonProperty("thumbnail_image_url")
            private String thumbnailImageUrl;

        }

    }

}