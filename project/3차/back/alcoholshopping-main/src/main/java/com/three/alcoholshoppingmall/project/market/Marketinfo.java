package com.three.alcoholshoppingmall.project.market;

import com.three.alcoholshoppingmall.project.purchase.Delivery;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
@Getter
@Setter
@Builder
public class Marketinfo {

        private Long marketcode;

        private String marketname;

        private String address;

        private String phonenumber;

        private Delivery delivery;

        private int stocknumber;

        private Time opentime;

        private Time closetime;
}
