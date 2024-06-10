package com.three.alcoholshoppingmall.project.review;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Reviewshow {

    private Long id;

    private String nickname;

    private Long alcoholcode;

    private String name;

    private String writing;

    private int grade;

    private String picture;

    private LocalDate date;

}
