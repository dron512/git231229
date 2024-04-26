package com.green.onezo.jwt;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
@Data
public class JwtTokenDto {

    private String accessToken;
    private String refeshToken;
}
