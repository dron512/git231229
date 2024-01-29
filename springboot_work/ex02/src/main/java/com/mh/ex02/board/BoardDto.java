package com.mh.ex02.board;

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
    private String title;
    private String content;

}
