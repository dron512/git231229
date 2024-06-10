package com.three.alcoholshoppingmall.project.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangePwDto {

    @Schema(title = "newPassword", description = "회원의 변경하고픈 password입니다.",example = "변경하고픈 비밀번호")
    @NotBlank(message = "변경하고픈 비밀번호를 입력하세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}",
            message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String newPassword;

    @Schema(title = "passwordch", description = "passwordch입니다.", example = "비밀번호 확인")
    @NotBlank(message = "비밀번호를 확인해주세요.")
    private String passwordch;

    @Schema(title = "email", description = "회원의 이메일입니다.", example = "이메일")
    private String email;

    @Schema(title = "tempPw", description = "임시비밀 번호입니다.", example = "임시비밀번호")
    @NotBlank(message = "비밀번호를 확인해주세요.")
    private String tempPw;
}
