package com.mh.green2nd.cart;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResDto {
    private Long cartId; // 카트 아이디
    private List<Long> menuIds; // 메뉴 아이디 리스트
    // 추가로 필요한 필드들을 여기에 추가하세요

    // 생성자, getter, setter 등을 추가하세요
}
