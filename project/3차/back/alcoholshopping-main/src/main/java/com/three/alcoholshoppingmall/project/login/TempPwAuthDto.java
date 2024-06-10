package com.three.alcoholshoppingmall.project.login;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Tag(name = "임시비밀번호 인증",description = "임시비밀번호 인증용 클래스입니다.")
public class TempPwAuthDto {

    private String email;
    private String tempPw;
}
