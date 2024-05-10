package com.mh.mychart.item;


import com.mh.mychart.item.itemimg.ItemImg;
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
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public List<ItemResDto> getItemList() {
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

        List<ItemResDto> list = new ArrayList<>();
        long preItemId = 0;
        for (ItemResDto result : results) {
            if (preItemId != result.getItem_id()) {
                preItemId = result.getItem_id();
                list.add(new ItemResDto(result.getName(), result.getPrice(),
                        result.getItem_id(), result.getItem_img_id(), result.getImg_path()));
            }
        }

        return list;
    }

    public List<ItemResDto> getItemListlazy() {
        QItem qItem = QItem.item;
        QItemImg qItemImg = QItemImg.itemImg;

        List<Item> results = jpaQueryFactory
                .select(
                        qItem
                )
                .from(qItem)
                .fetch();
        List<ItemImg> results_img = jpaQueryFactory
                .select(
                        qItemImg
                )
                .from(qItemImg)
                .limit(1)
                .fetch();
        List<ItemResDto> list = new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            Item item = results.get(0);
            ItemImg itemImg = results_img.get(0);
            list.add(new ItemResDto(item.getName(), item.getPrice(),
                    item.getId(), itemImg.getId(), itemImg.getImgPath()));
        }
        return list;
    }


}
