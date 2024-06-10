package com.three.alcoholshoppingmall.project.user;


import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Tag(name = "UserInfo",description = "유저 정보 클래스")
public class UserInfo {

    @Schema(title = "nickname",description = "회원 닉네임")
    private String nickname;
    @Schema(title = "phone",description = "회원 휴대폰 번호")
    private String phone;
    @Schema(title = "address",description = "회원 전체 주소")
    private String address;
    @Schema(title = "address2", description = "회원의 상세 주소 입니다.", example = "상세주소")
    private String address2;
    @Schema(title = "email",description = "회원 이메일")
    private String email;

}
