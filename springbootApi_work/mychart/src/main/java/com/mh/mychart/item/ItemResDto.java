package com.mh.mychart.item;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ItemResDto {

    private String name;
    private int price;
    private long item_id;
    private long item_img_id;
    private String img_path;

    @QueryProjection
    public ItemResDto(String name, int price, long item_id, long item_img_id, String img_path) {
        this.name = name;
        this.price = price;
        this.item_id = item_id;
        this.item_img_id = item_img_id;
        this.img_path = img_path;
    }
}
