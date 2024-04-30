package com.mh.mychart.order.orderitem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.mychart.item.Item;
import com.mh.mychart.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Long orderItemId;

    private String orderItemName;
    private int orderItemPrice;
    private int orderItemQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    public Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    public Item item;

}
