package com.mh.mybatistest.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {


    @Autowired
    ItemRepository itemRepository;

    @GetMapping("item")
    public String  doItem(){
        // insert 구문 자동 실행...
        itemRepository.save(new Item(1l,"myItem"));
        return "test";
    }
}
