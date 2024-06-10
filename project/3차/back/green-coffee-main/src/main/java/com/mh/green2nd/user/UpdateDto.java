package com.mh.green2nd.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateDto {
    @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$", message = "이메일 양식에 맞게 입력해주세요.")
    @NotNull(message = "이메일은 필수 입력 사항입니다.")
//    @JsonIgnore
    private String email;


    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}", message = "비밀번호 양식에 맞게 입력해주세요.")
    @Schema(title = "패스워드",description = "패스워드 입력부분입니다")
    private String password;

    @Column()
    @Schema(title = "닉네임",description = "닉네임의 길이는 2~20자 사이여야 합니다.")
    private String nickname;

    @Pattern(regexp = "\\d{11}", message = "휴대폰 번호는 11자리의 숫자로 이루어져야 합니다.")
    @Schema(title = "휴대폰")
    private String phone;

    //    @Pattern(regexp = "(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])", message = "생년월일은 YYMMDD 형식이어야 합니다.")
    @Pattern(regexp = "\\d{2}(0?[1-9]|1[012])(0?[1-9]|[12]\\d|3[01])", message = "생년월일은 YYMMDD 형식이어야 합니다.")
    @Schema(title = "생년월일")
    private String birthdate;
}