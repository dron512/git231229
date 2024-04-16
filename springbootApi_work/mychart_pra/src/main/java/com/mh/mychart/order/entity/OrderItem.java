package com.mh.mychart.order.entity;

import com.mh.mychart.base.BaseEntity;
import jakarta.persistence.*;

@Entity
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;



}
