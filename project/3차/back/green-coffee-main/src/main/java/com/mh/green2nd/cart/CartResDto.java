package com.mh.green2nd.cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResDto {
    private Long cartId; // 카트 아이디
    private List<Long> menuIds; // 메뉴 아이디 리스트
}
