package com.mh.mychart.item;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>,
        ItemRepositoryCustom{

    // select * from item whre itemnm = itemnm
    Optional<Item> findByName(String name);

    List<Item> findByPriceLessThan(int price);

    List<Item> findByPriceLessThanOrderByPriceDesc(int price);

    @Query("select i from Item i where i.price < :price order by i.price desc")
    Item myCustom(int price);

    @Query(value = "SELECT a.name,a.price,a.item_id, b.item_img_id,b.img_path "+
            " FROM item a,"+
            "  ( SELECT a.item_id,"+
            "            min(a.item_img_id) AS 'item_img_id',"+
            "             min(a.img_path) AS 'img_path'"+
            "    FROM item_img a"+
            "    GROUP BY a.item_id ) b"+
            "      where a.item_id = b.item_id",nativeQuery = true)
    List<Map> getItemListJPQL();

}
