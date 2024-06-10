package com.mh.green2nd.menu;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
@Tag(name = "메뉴창 메뉴컨트롤러", description = "전체메뉴와 눌렀을 때 상세메뉴")
@SecurityRequirement(name = "Bearer Authentication")
public class MenuController {

    private final MenuService menuService;

    @Operation(summary = "커피 전체 메뉴 따로 값 입력 받지 않고 그냥 보여줌")
    @GetMapping("/coffee")
    public ResponseEntity<List<Menu>> menuc(MenuDto menuDto){
        List<Menu> result = menuService.coffee();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "음료 전체 메뉴 따로 값 입력 받지 않고 그냥 보여줌")
    @GetMapping("/beverage")
    public ResponseEntity<List<Menu>> menub(MenuDto menuDto){
        List<Menu> result = menuService.beverage();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "음식 전체 메뉴 따로 값 입력 받지 않고 그냥 보여줌")
    @GetMapping("/food")
    public ResponseEntity<List<Menu>> menuf(MenuDto menuDto){
        List<Menu> result = menuService.food();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "굿즈 전체 메뉴 따로 값 입력 받지 않고 그냥 보여줌")
    @GetMapping("/goods")
    public ResponseEntity<List<Menu>> menug(MenuDto menuDto){
        List<Menu> result = menuService.goods();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "메뉴 눌렀을 때 상세화면 여기에는 값 입력해야함")
    @PostMapping("/detail")
    public ResponseEntity<List<Menu>> detail(@RequestBody MenuSearchDto menuSearchDto){
        List<Menu> result = menuService.detail(menuSearchDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(summary = "검색 기능 = ex)라떼라고 검색어 치면 라떼 들어간거 검색되고 공백말고 스페이스 한번 누르면 전부 검색됨")
    @GetMapping("/{name}")
    public ResponseEntity<List<Menu>> menuf(@PathVariable(required = false) String name, MenuSearchDto menuSearchDto){
        List<Menu> result = menuService.search(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
