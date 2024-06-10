package com.three.alcoholshoppingmall.project.market;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.purchase.Delivery;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@Builder
public class MarketDTO {


    private Long marketcode;


    private String marketname;

    private String address;

    private String phonenumber;

    private Delivery delivery;

    private Time opentime;

    private Time closetime;
}
