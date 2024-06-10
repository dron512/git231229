package com.mh.green2nd.custom;

import com.mh.green2nd.cart.CartRepository;
import com.mh.green2nd.cart.cartMenu.CartMenuRepository;
import com.mh.green2nd.cart.cartMenu.CartMenuService;
import com.mh.green2nd.custom.customMenu.CustomMenu;
import com.mh.green2nd.jwt.TokenManager;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor

public class CustomService {

    private final CustomRepository customRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final CartMenuRepository cartMenuRepository;
    private final CartMenuService cartMenuService;
    private final TokenManager tokenManager;

    public CustomResDto addToCustom(CustomReqDto customReqDto, User user) {
        User customUser = userRepository.findById(user.getUser_id())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 사용자가 없습니다."));
        Menu menu = menuRepository.findById(customReqDto.getMenuId())
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 메뉴가 없습니다."));

        // 사용자의 나만의메뉴 가져오기
        Custom custom = customRepository.findByUser(customUser).orElse(new Custom());
        if (custom.getCustomMenus().isEmpty()) {
//        if (custom.getCartMenusList().isEmpty()) {
            custom.setUser(customUser);
        }

        // 나만의 메뉴에 이미 존재하는 메뉴인지 확인
        CustomMenu existingCustomMenu = custom.getCustomMenus().stream()
                .filter(customMenu -> customMenu.getMyname().equals(customReqDto.getMyname()))
                .findFirst()
                .orElse(null);

        // 이미 존재하는 이름이라면
        if (existingCustomMenu != null) {
            throw new IllegalArgumentException("이미 같은 이름의 나만의 메뉴가 있습니다. 다른 이름을 사용해주세요.");
        } else {

            CustomMenu customMenu = new CustomMenu();
            customMenu.setMenu(menu);
            customMenu.setCustom(custom);
            customMenu.setMyname(customReqDto.getMyname());

            customMenu.setSize(customReqDto.getSize());
            customMenu.setIce(customReqDto.getIce());
            customMenu.setShot(customReqDto.getShot());
            customMenu.setCream(customReqDto.getCream());

            custom.getCustomMenus().add(customMenu);
        }

        customRepository.save(custom);
        CustomResDto customResDto = new CustomResDto();
        return customResDto;

    }

    /*



     */


}
