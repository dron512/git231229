package com.three.alcoholshoppingmall.project.login;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "로그인 클래스")
public class Login {

    @Schema(description = "이메일", example = "bbb@naver.com")
    private String email;
    @Schema(description = "비밀번호", example =  "a123456!")
    private String password;
}
