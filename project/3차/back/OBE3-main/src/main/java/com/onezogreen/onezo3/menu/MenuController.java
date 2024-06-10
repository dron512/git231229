package com.onezogreen.onezo3.menu;

import com.onezogreen.onezo3.exception.BizException;
import com.onezogreen.onezo3.exception.ErrorCode;
import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {

    public final MenuService menuService;

    @GetMapping("/soldOut/select/{menu_category}")
    @Operation(summary = "메뉴 조회합니다", description = "카테고리는 ALL, SET,CHICKEN,SIDE,DRINK,SAUCE 로 값을 넘겨주세요")
    public List<MenuVo> selectMenu(@PathVariable String menu_category, Authentication authentication){
        ManagerVo managerVo = (ManagerVo)authentication.getPrincipal();
        Long store_id = managerVo.getStore_id();
        List<MenuVo> menuList = menuService.menuSelect(store_id ,menu_category);
        if(menuList == null || menuList.isEmpty()){
            throw new BizException(ErrorCode.NOTSELECT);
        }
        return menuList;
    }

    @PutMapping("/soldOut/update/{menu_id}")
    @Operation(summary = "메뉴에 품절상태를 바꿉니다", description = "픔절여부 N -> Y 또는 Y -> N")
    public boolean changeSoldOut(@PathVariable Long menu_id, @RequestBody MenuVo menuVo, Authentication authentication){
        ManagerVo managerVo = (ManagerVo)authentication.getPrincipal();
        Long store_id = managerVo.getStore_id();
        boolean soldOutCheck = menuService.soldOutChange(store_id, menu_id, menuVo);
        if(soldOutCheck == false){
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return soldOutCheck;
    }

}
