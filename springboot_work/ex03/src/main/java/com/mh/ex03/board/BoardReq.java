package com.mh.ex03.board;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BoardReq {

    @NotBlank(message = "이름은 입력하세요")
    private String name;

    @Size(min=10,message = "내용은 10글자 이상이어야 합니다.")
    private String content;

    @Size(min=2,message = "제목을 2글자 이상 입력하세요.")
    private String title;
}
