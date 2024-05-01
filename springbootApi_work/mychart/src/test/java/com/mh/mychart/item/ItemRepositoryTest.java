package com.mh.mychart.item;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    @DisplayName("상품가격이하")
    public void lessThenTest() {

        List<Item> item = itemRepository.findByPriceLessThan(1200);
        System.out.println(item);

    }

    @Test
    @DisplayName("상품가격이하정렬")
    public void lessThenOrderTest() {

        List<Item> item = itemRepository.findByPriceLessThanOrderByPriceDesc(1500);
//        System.out.println(item);

        item.forEach(System.out::println);
    }

    @Test
    @DisplayName("상품이름Like")
    public void likeTest() {

        QItem qItem = QItem.item;
        jpaQueryFactory.selectFrom(qItem)
                .where(qItem.name.like("%0%"))
                .fetch()
                .forEach(System.out::println);

    }
}