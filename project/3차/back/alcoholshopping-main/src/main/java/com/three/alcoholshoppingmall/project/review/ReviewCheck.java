package com.three.alcoholshoppingmall.project.review;


import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.purchase.Division;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ReviewCheck {

    private Long alcoholcode;

    private String name;

    private LocalDate purchaseday;

    private String marketname;

    private Delivery delivery;

    private String picture;


}
