package com.three.alcoholshoppingmall.project.favorites;


import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Favoritesalcohol {


    private Long code;

    private String name;

    private String picture;


}
