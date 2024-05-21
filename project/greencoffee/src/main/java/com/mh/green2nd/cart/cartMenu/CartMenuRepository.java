package com.mh.green2nd.cart.cartMenu;

import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartMenuRepository extends JpaRepository<CartMenu, Long>{

    void deleteByCartAndMenu(Cart cart, Menu menu);
}
