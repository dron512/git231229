package com.three.alcoholshoppingmall.project.purchase;


import lombok.*;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BuyList {
    //이미지	제품명	주문일자	매장명	주문번호	주문방식	주소	수량	결제금액

    private String image;
    private Long productname;
    private Date orderdate;
    private String marketname;
    private String ordernum;
    private String delivery;
    private String address;
    private String address2;
}