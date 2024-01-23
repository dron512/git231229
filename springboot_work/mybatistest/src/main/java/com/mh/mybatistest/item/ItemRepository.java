package com.mh.mybatistest.item;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item,Long> {

}
