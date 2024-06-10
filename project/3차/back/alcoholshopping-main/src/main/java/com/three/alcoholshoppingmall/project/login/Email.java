package com.three.alcoholshoppingmall.project.login;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Tag(name = "이메일 클래스",description = "이메일 인증용 클래스입니다.")
public class Email {
    

    @Pattern(regexp = "(^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)",
            message = "이메일 형식을 확인해 주세요")
    @Schema(example = "이메일")
    private String email;


}
