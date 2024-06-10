package com.three.alcoholshoppingmall.project.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserUpdate {


    @Schema(title = "nickname", description = "회원의 nickname입니다.", example = "닉네임")
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;


    @Schema(title = "phone", description = "회원의 전화번호 입니다.", example = "전화번호 11자리")
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^(010)([0-9]{4})([0-9]{4})", message = "올바른 휴대폰 번호를 입력하세요.")
    private String phone;

    @Schema(title = "address", description = "회원의 주소 입니다.", example = "주소")
    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    @Schema(title = "address2", description = "회원의 상세 주소 입니다.", example = "상세주소")
    @NotBlank(message = "상세주소를 입력해주세요.")
    private String address2;


}
