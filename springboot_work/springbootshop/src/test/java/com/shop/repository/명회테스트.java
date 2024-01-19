package com.shop.repository;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
@TestPropertySource(locations = "classpath:application-test.properties")
public class 명회테스트 {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void test() {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());

        itemRepository.save(item);
        Item findItem = itemRepository.findById(1l).orElse(null);

        assertThat(item.getId()).isEqualTo(findItem.getId());
    }

    @Test
    public void 상품조회테스트(){
        MyItemService myItemService = new MyItemService();
    }
}
