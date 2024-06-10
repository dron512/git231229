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
public class PwUpdate {
    @Schema(title = "password", description = "회원의 password입니다.",example = "비밀번호")
    @NotBlank(message = "비밀번호를 입력하세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @Schema(title = "newPassword", description = "회원의 변경하고픈 password입니다.",example = "변경하고픈 비밀번호")
    @NotBlank(message = "변경하고픈 비밀번호를 입력하세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String newPassword;

    @Schema(title = "passwordch", description = "회원의 passwordch입니다.", example = "비밀번호 확인")
    @NotBlank(message = "비밀번호를 확인해주세요.")
    private String passwordch;


}
