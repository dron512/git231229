package com.mh.mychart.order;

import com.mh.mychart.member.Member;
import com.mh.mychart.order.orderitem.OrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    private String orderName;

    // 기본값이 EAGER 인데 이건 select 한번 취하는거..
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private Member member;

    // OneToMany 는 select 두번 한다.. 나중에 취야는 전략
    // OrderItem casecade
    @OneToMany(mappedBy = "order",
                    fetch = FetchType.EAGER, // select
                    cascade = CascadeType.ALL // item저장
                 , orphanRemoval = true// 고아객체제거
    )
    private List<OrderItem> orderItems = new ArrayList<>();
}
