package com.mh.mychart.item.dto;

import com.mh.mychart.item.Entity.Item;
import com.mh.mychart.member.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

    private Long id;

    private String name;
    private String description;
    private int price;
    private int stock;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
    private Member member;

    public Item toEntity() {
        return Item.builder()
                .itemId(id)
                .itemNm(name)
                .description(description)
                .price(price)
                .stock(stock)
                .member(member)
                .build();
    }
}
