package com.mh.green2nd.menu.recommend;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class RecommendController {

    private final MenuService menuService;

    // 추천 메뉴 리스트 조회
    @Operation(summary = "추천 메뉴 리스트 조회")
    @GetMapping("/recommend/list")
    public ResponseEntity<List<Menu>> getRecommendMenuList() {
        List<Menu> recommendMenuList = menuService.recommend();
        return new ResponseEntity<>(recommendMenuList, HttpStatus.OK);
    }

}
