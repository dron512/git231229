package com.mh.mychart.item.itemimg;

import com.mh.mychart.item.Item;
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
public class ItemImg{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id", nullable = false)
    private Long id;

    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;

}

