package com.green.onezo.menu;

import com.green.onezo.cart.CartItem;
import com.green.onezo.store.Store;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    private String link;
    private String imageSrc;
    private String rating;
    private String productNm;
    private String subinfo;
    private int price;


}
