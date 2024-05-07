package com.mh.mychart.item;


import com.mh.mychart.item.itemimg.QItemImg;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public List<ItemResDto> getItemList(){
        QItem qItem = QItem.item;
        QItemImg qItemImg = QItemImg.itemImg;

        List<ItemResDto> results = jpaQueryFactory
                .select(
                        new QItemResDto(
                                qItem.name,
                                qItem.price,
                                qItem.id,
                                qItemImg.id,
                                qItemImg.imgPath)
                )
                .from(qItem)
                .leftJoin(qItemImg)
                .on(qItem.id.eq(qItemImg.item.id))
                .fetch();
        System.out.println(results);

        List<ItemResDto> list = new ArrayList<>();
        long preItemId = 0;
        for ( ItemResDto result : results) {
            if(preItemId != result.getItem_id()){
                preItemId = result.getItem_id();
                list.add(new ItemResDto(result.getName(), result.getPrice(),
                        result.getItem_id(), result.getItem_img_id(), result.getImg_path()));
            }
        }
        System.out.println(list);

        return list;
    }


}
