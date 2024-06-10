package com.mh.green2nd.cart.cartMenu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.cart.Cart;
import com.mh.green2nd.menu.Menu;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "cart_menu")
public class CartMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartmenu_id", nullable = false)
    private Long cartmenu_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Max(20)
    private int quantity;

    @Max(2)
    @Min(0)
    private int size;

    @Max(2)
    @Min(0)
    private int ice;

    @Max(3)
    @Min(0)
    private int shot;

    @Max(3)
    @Min(0)
    private int cream;

    @Column(name = "sub_cart_price")
    private double subCartPrice;

    @PostLoad
    @PostPersist
    public void calculateSubCartPrice() {
        double menuPrice = menu.getMenu_price();
        int optionPrice = (int) (menu.getPrice_size() * size + menu.getPrice_shot() * shot + menu.getPrice_cream() * cream);
        this.subCartPrice = (menuPrice + optionPrice) * quantity;
    }
}
