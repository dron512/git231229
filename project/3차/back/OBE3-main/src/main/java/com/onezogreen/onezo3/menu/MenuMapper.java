package com.onezogreen.onezo3.menu;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MenuMapper {
    // 관리자 페이제에서 조회하는 메뉴들
    List<MenuVo> menuSelect(MenuVo menuVo);

    // 품절 수정(y->n, n->y)
    boolean soldOutChange(MenuVo menuVo);
}
