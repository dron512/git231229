package com.onezogreen.onezo3.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    @Schema(example = "jjj200820@gmail.com")
    private String email;
    @Schema(example = "1111")
    private String password;

}
