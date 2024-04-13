package com.mh.mychart.item;

import com.mh.mychart.item.Entity.Item;
import com.mh.mychart.item.Entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
    List<ItemImg> findByItem(Item item);
}
