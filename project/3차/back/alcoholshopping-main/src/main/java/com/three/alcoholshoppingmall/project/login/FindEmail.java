package com.three.alcoholshoppingmall.project.login;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindEmail {
    @Schema(title = "생년월일", description = "생년월일을 입력하는 칼럼입니다.", example = "19970128")
    private String birthdate;
    @Schema(title = "휴대전화번호", description = "휴대전화번호를 입력하는 칼럼입니다.", example = "01011111111")
    private String phone;

}
