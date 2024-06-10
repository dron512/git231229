package com.three.alcoholshoppingmall.project.login.token;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    @Schema(description = "액세스 토큰")
    private String access_token;
    @Schema(description = "리프레쉬 토큰")
    private String refresh_token;
}
