package com.mh.ex04.board;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardReq {

    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String name;
}
