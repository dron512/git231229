package com.example.mateproject.proc_test.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentPost {
    private int post_idx;
    private String post_content;
    private String post_writer;
}
