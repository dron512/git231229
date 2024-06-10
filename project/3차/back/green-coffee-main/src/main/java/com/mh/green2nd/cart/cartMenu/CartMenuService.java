package com.mh.green2nd.cart.cartMenu;

import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartMenuService {

    private final CartMenuRepository cartMenuRepository;

    public CartMenu createCartMenu(Cart cart, Menu menu, int quantity) {
        CartMenu cartMenu = new CartMenu();
        cartMenu.setCart(cart);
        cartMenu.setMenu(menu);
        cartMenu.setQuantity(quantity);
        return cartMenuRepository.save(cartMenu);
    }

    public double calculateSubCartPrice(CartMenu cartMenu) {
        int quantity = cartMenu.getQuantity();
        int size = cartMenu.getSize();
        int shot = cartMenu.getShot();
        int cream = cartMenu.getCream();
        Menu menu = cartMenu.getMenu();
        int price_size = menu.getPrice_size();
        int price_shot = menu.getPrice_shot();
        int price_cream = menu.getPrice_cream();

        double menuPrice = menu.getMenu_price();
        int optionPrice = price_size * size + price_shot * shot + price_cream * cream;
        return (menuPrice + optionPrice) * quantity;
    }

}
