package com.mh.green2nd.orders;


import com.mh.green2nd.orders.orderitem.OrderMenu;
import com.mh.green2nd.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @OneToMany(mappedBy = "order",
            fetch = FetchType.LAZY, // select
            cascade = CascadeType.ALL // item저장
            , orphanRemoval = true// 고아객체제거
    )
    private List<OrderMenu> orderItems = new ArrayList<>();
    private LocalDateTime create_date = LocalDateTime.now();

    @Column(name = "total_order_price")
    private double totalOrderPrice;
    public void addToTotalCartPrice(double price) {
        this.totalOrderPrice += price;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;




}
