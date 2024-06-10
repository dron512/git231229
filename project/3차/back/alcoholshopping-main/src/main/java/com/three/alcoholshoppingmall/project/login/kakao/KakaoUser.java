package com.three.alcoholshoppingmall.project.login.kakao;

import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KakaoUser {

    private String email;
    private String nickname;
}
