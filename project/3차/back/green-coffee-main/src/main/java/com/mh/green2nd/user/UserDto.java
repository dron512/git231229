package com.mh.green2nd.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UserDto {

    @Pattern(regexp = "^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\\.[A-Za-z0-9\\-]+$", message = "이메일 양식에 맞게 입력해주세요.")
    @Schema(title = "이메일",description = "이메일 입력")
    @NotBlank(message = "이메일은 필수 입력 사항입니다. 최소2 최대20")
    private String email;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{6,20}", message = "비밀번호 양식에 맞게 입력해주세요.")
    @Schema(title = "패스워드",description = "패스워드 입력부분입니다")
    @NotBlank(message = "비밀번호는 필수 입력 사항입니다. 최소6 최대20")

    private String password;

    @Column()
    @Size(min = 2,max = 20, message = "닉네임의 길이는 2~20자 사이여야 합니다.")
    @Schema(title = "닉네임",description = "닉네임 입력부분입니다")
    private String nickname;

    @Pattern(regexp = "\\d{11}", message = "휴대폰 번호는 11자리의 숫자로 이루어져야 합니다.")
    @Schema(title = "휴대폰",description = "휴대폰 입력부분입니다")
    private String phone;

    @Pattern(regexp = "\\d{2}(0?[1-9]|1[012])(0?[1-9]|[12]\\d|3[01])", message = "생년월일은 YYMMDD 형식이어야 합니다.")
    @Schema(title = "생년월일",description = "생년월일 입력부분입니다")
    private String birthdate;




}