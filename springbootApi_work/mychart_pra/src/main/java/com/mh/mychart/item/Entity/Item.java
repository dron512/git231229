package com.mh.mychart.item.Entity;

import com.mh.mychart.base.BaseEntity;
import com.mh.mychart.member.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long itemId;

    private String itemNm;
    private String description;
    private int price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
