package com.three.alcoholshoppingmall.project.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserSub {


    @Schema(title = "nickname", description = "회원의 nickname입니다.",example = "닉네임")
    private String nickname;

    @Schema(title = "address", description = "회원의 주소 입니다.",example = "주소")
    private String address;

    @Schema(title = "lastaddress", description = "회원의 상세 주소 입니다.",example = "상세주소")
    private String address2;
}
