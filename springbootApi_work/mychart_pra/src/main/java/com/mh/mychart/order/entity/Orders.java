package com.mh.mychart.order.entity;


import com.mh.mychart.base.BaseEntity;
import com.mh.mychart.member.Member;
import jakarta.persistence.*;

@Entity
public class Orders extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
