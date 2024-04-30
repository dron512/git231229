package com.mh.mychart.order.orderitem;

import com.mh.mychart.order.Order;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String orderItemName;
    private String orderItemPrice;
    private String orderItemQuantity;

    @ManyToOne
    public Order order;

}
