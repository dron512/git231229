package com.green.onezo.cart;

import com.green.onezo.member.Member;
import com.green.onezo.menu.Menu;
import com.green.onezo.store.Store;

public class CartDto {

    private Long id;
    private Member member;
    private Store store;
    private Menu menu;
    private int quantity;
    private TakeInOut takeInOut;


}
