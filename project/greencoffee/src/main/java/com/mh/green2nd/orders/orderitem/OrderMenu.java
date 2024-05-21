package com.mh.green2nd.orders.orderitem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.orders.Order;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderitem")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_menu_id")
    private Long orderMenuId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Column(name = "sub_price")
    private double subPrice;

    private int quantity;

    @PostLoad
    @PostPersist
    public void calculateSubCartPrice() {
        double menuPrice = menu.getMenu_price();
        int optionPrice = ice * 200 + shot * 500 + cream * 500;
        this.subPrice = (menuPrice + optionPrice) * quantity;
    }

    private int ice;
    private int shot;
    private int cream;
}
