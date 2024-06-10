package com.onezogreen.onezo3.login;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDto {

    private String accessToken;

}
