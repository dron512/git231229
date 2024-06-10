package com.three.alcoholshoppingmall.project.purchase;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.shoppingbasket.Shoppingbasket;
import com.three.alcoholshoppingmall.project.stock.Stock;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicInsert
@Schema(title = "DB 유효성 검사하는 회원의 구매 정보")
public class PurchaseDTO {

    private String ordernumber;

    private User user;

    private Stock stock;

    private int amount;

    private int price;

    private Delivery delivery;

    @JsonIgnore
    private Division division;

    private String address;

    private String address2;

    private String picture;

    @JsonIgnore
    private LocalDate purchaseday;

}