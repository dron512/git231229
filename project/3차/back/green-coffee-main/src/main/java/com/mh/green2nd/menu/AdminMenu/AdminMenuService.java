package com.mh.green2nd.menu.AdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMenuService {

    private final MenuRepository menuRepository;

    // admin만 메뉴 조회 가능
    @Transactional
    public List<AdminMenuGetDto> getMenuList(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get menu list");
        }
        List<Menu> menus = menuRepository.findAll();
        List<AdminMenuGetDto> adminMenuGetDtos = new ArrayList<>();
        for (Menu menu : menus) {
            AdminMenuGetDto adminMenuGetDto = new AdminMenuGetDto();
            adminMenuGetDto.setId(menu.getMenu_id());
            adminMenuGetDto.setName(menu.getName());
            adminMenuGetDto.setPrice((int) menu.getMenu_price());
            adminMenuGetDto.setExplain(menu.getMenu_explain());
            adminMenuGetDto.setStatus(menu.isStatus());
            adminMenuGetDto.setMenu_imgurl(menu.getMenu_imgurl());
            adminMenuGetDto.setCategory(menu.getCategory());
            adminMenuGetDtos.add(adminMenuGetDto);
        }
        return adminMenuGetDtos;
    }

    // admin만 메뉴 상태 수정 가능
    @Transactional
    public Menu updateMenuStatus(User user, Long menuId, boolean status) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update menu status");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setStatus(status);
        return menuRepository.save(menu);
    }
}