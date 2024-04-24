package com.green.onezo.member;


//import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;

import com.green.onezo.enum_column.Resign_yn;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//    @Schema(description = "회원 유효성 검사를 위한 객체입니다.")
public class MemberDTO {
    //자동증가 키
    private Long user_id;

    @NotBlank(message = "아이디는 필수 입력 사항입니다.")
    @Size(min = 2, max = 20, message = "아이디는 최소 2자 이상 20자 이하로 입력해야합니다.")
    @Schema(description = "사용자 고유 아이디")
    private String ID;

    @NotBlank(message = "패스워드는 필수 입력 사항입니다.")
    @Size(min = 4, max = 20, message = "패스워드는 최소 4자 이상 20자 이하로 입력해야합니다.")
    private String password;

    @NotBlank
    @Size(max = 10, message = "이름은 10자까지 입력이 가능합니다.")
    @Schema(description = "사용자 이름")
    private String name;

    @Size(min = 2, max = 10, message = "닉네임의 크기는 2에서 10 사이여야 합니다.")
    @Schema(description = "사용자의 닉네임")
    private String nickname;

    @Schema(description = "사용자의 전화번호", example = "010-5157-7131")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호 양식에 맞지 않습니다. XXX-XXXX-XXXX 형식으로 입력해주세요.")
    @NotBlank(message = "전화번호는 필수 입력 사항입니다.")
    private String phone;

    @Schema(description = "사용자의 탈퇴여부")
    private Resign_yn resign_yn;

}


