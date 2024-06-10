package com.mh.green2nd.cart;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartMenu> cartMenusList = new ArrayList<>();

    @Column(name = "total_cart_price")
    private double totalCartPrice;
    public void addToTotalCartPrice(double price) {
        this.totalCartPrice += price;
    }

    public void clearItems() {
        this.cartMenusList.clear();
    }


}
