package com.mh.green2nd.menu.SuperAdminMenu;

import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuDto;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuperAdminMenuService {

    private final MenuRepository menuRepository;

    //superadmin만 새로운 메뉴 생성 가능
    public Menu createMenu(User user, MenuDto menuDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can create menus");
        }
        Menu menu = new Menu();
        BeanUtils.copyProperties(menuDto, menu);
        return menuRepository.save(menu);
    }

    //superadmin만 메뉴 삭제 가능
    public void deleteMenu(User user, Long menuId) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can delete menus");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menuRepository.delete(menu);
    }

    // superadmin만 메뉴 조회 가능
    public List<SuperAdminMenuGetDto> getMenuList(User user) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can get menu list");
        }
        List<Menu> menus = menuRepository.findAll();
        List<SuperAdminMenuGetDto> superAdminMenuGetDtos = new ArrayList<>();
        for (Menu menu : menus) {
            SuperAdminMenuGetDto superAdminMenuGetDto = new SuperAdminMenuGetDto();
            superAdminMenuGetDto.setId(menu.getMenu_id());
            superAdminMenuGetDto.setName(menu.getName());
            superAdminMenuGetDto.setPrice((int) menu.getMenu_price());
            superAdminMenuGetDto.setExplain(menu.getMenu_explain());
            superAdminMenuGetDto.setEname(menu.getMenu_ename());
            superAdminMenuGetDto.setCategory(menu.getCategory());
            superAdminMenuGetDto.setVisible(menu.isVisible());
            superAdminMenuGetDto.setRecommend(menu.isRecommend());
            superAdminMenuGetDtos.add(superAdminMenuGetDto);
        }
        return superAdminMenuGetDtos;
    }

    //superadmin만 메뉴 수정 가능
    public Menu updateMenu(User user, Long menuId, SuperAdminMenuUpdateDto superAdminMenuUpdateDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update menus");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        if (superAdminMenuUpdateDto.getName() != null) {
            menu.setName(superAdminMenuUpdateDto.getName());
        }
        if (superAdminMenuUpdateDto.getPrice() != null) {
            menu.setMenu_price(superAdminMenuUpdateDto.getPrice());
        }
        if (superAdminMenuUpdateDto.getExplain() != null) {
            menu.setMenu_explain(superAdminMenuUpdateDto.getExplain());
        }
        if (superAdminMenuUpdateDto.getEname() != null) {
            menu.setMenu_ename(superAdminMenuUpdateDto.getEname());
        }
        if (superAdminMenuUpdateDto.getCategory() != null) {
            menu.setCategory(superAdminMenuUpdateDto.getCategory());
        }
        if (superAdminMenuUpdateDto.getVisible() != null) {
            menu.setVisible(superAdminMenuUpdateDto.getVisible());
        }
        return menuRepository.save(menu);
    }

    //superadmin만 추천메뉴 수정 가능
    public Menu updateRecommend(User user, Long menuId, boolean recommend) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update recommend");
        }
        Menu menu = menuRepository.findById(menuId).orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setRecommend(recommend);
        return menuRepository.save(menu);
    }

}