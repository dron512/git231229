package com.mh.mychart.member;

import com.mh.mychart.base.constenum.Role;
import com.mh.mychart.config.token.TokenManager;
import com.mh.mychart.kakao.KakaoTokenClient;
import com.mh.mychart.kakao.KakaoTokenDto;
import com.mh.mychart.kakao.KakaoUserInfoClient;
import com.mh.mychart.kakao.KakaoUserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final KakaoTokenClient kakaoTokenClient;
    private final KakaoUserInfoClient kakaoUserInfoClient;

    private final MemberService memberService;
    private final TokenManager tokenManager;

    @Value("${kakao.client.id}")
    private String clientId;

    @Value("${kakao.client.secret}")
    private String clientSecret;

    @GetMapping("test/token")
    public String getToken(){
        return tokenManager.generateToken(Member.builder().memberId(1L).username("test").role(Role.USER).email("aaa@naver.com").build());
    }

    @GetMapping("oauth/kakao/callback")
    public String kakaoCallback(String code) {
        System.out.println("카카오 인증 완료 인가 코드"+code);
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";

        KakaoTokenDto.Request kakaoTokenRequestDto = KakaoTokenDto.Request.builder()
                .client_id(clientId)
                .client_secret(clientSecret)
                .grant_type("authorization_code")
                .code(code)
                .redirect_uri("http://localhost:8080/oauth/kakao/callback")
                .build();

        System.out.println(clientId);
        System.out.println(clientSecret);

        KakaoTokenDto.Response kakoTokenResponseDto = kakaoTokenClient.requestKakaoToken(contentType, kakaoTokenRequestDto);
        System.out.println(kakoTokenResponseDto);

        KakaoUserInfoResponseDto kakaoUserInfoResponseDto = kakaoUserInfoClient.getKakaoUserInfo(contentType, "Bearer "+kakoTokenResponseDto.getAccess_token());
        System.out.println(kakaoUserInfoResponseDto);

        Member member = kakaoUserInfoResponseDto.toEntity();
        member.setRole(Role.USER);
        String token = memberService.save(member);

        return token;
    }

    private void test( @SpringQueryMap KakaoTokenDto.Request request){
        System.out.println(request);
    }
}
