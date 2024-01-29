package com.example.mateproject.proc_test.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Product_reply {
    private int idx_reply;
    private int idx_products;
    private int ref_idx_reply;
    private int ref_level;
    private String content;
    private String path;
}
