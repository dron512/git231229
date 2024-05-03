package com.mh.mychart.item;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public List<ItemResDto> getItemList(){
        QItem qItem = QItem.item;
        List<Item>  itemList = jpaQueryFactory.selectFrom(qItem).fetch();
        System.out.println(itemList);
        return null;
    }

}
