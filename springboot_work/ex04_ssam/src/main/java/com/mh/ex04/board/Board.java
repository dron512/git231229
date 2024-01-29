package com.mh.ex04.board;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {
    private int idx;
    private String title;
    private String content;
    private String name;
    private String originalfilename;
}
