package com.mh.mychart.item.Entity;

import com.mh.mychart.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name="item_img")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemImg extends BaseEntity {

    @Id
    @Column(name="item_img_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imgName; //이미지 파일명

    private String oriImgName; //원본 이미지 파일명

    private String imgUrl; //이미지 조회 경로

    private String repimgYn; //대표 이미지 여부

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}