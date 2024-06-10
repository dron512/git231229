package com.three.alcoholshoppingmall.project.alcohol;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alcoholmain {

    private Long code;

    private String name;

    private String picture;

    private int price;

    private double ratingaverage;
}
