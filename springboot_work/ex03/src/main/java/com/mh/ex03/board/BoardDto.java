package com.mh.ex03.board;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private int idx;
    private String name;
    private String content;
    private String title;
}
