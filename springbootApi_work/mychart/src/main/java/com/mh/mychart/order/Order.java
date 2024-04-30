package com.mh.mychart.order;

import com.mh.mychart.member.Member;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String orderName;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
