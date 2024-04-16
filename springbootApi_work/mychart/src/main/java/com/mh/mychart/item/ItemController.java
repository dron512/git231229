package com.mh.mychart.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    react 에서 item 추가
    스프링부트 item 추가 해서 mysql DB 저장하는거
    카카오
 */
@RestController
@RequestMapping("api/item")
public class ItemController {

    @PostMapping("/new")
    public ResponseEntity<ItemDto> newItem() {
        System.out.println("new item");
        return ResponseEntity
                .status( HttpStatus.OK )
                .body( new ItemDto("아메리카노", 2000) );
    }
}
