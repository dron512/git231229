package com.mh.mychart.item;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.mh.mychart.item.QItemResDto is a Querydsl Projection type for ItemResDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QItemResDto extends ConstructorExpression<ItemResDto> {

    private static final long serialVersionUID = -1194908437L;

    public QItemResDto(com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Long> item_id, com.querydsl.core.types.Expression<Long> item_img_id, com.querydsl.core.types.Expression<String> img_path) {
        super(ItemResDto.class, new Class<?>[]{String.class, int.class, long.class, long.class, String.class}, name, price, item_id, item_img_id, img_path);
    }

}

