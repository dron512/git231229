package com.green.onezo.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/list")
    public ResponseEntity<List<Menu>> list(){
        List<Menu> menuList = menuService.allMenuView();
        return ResponseEntity.status(HttpStatus.OK).body(menuList);
    }

}
