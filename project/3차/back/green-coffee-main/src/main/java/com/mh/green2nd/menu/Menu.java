package com.mh.green2nd.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    @Schema(title = "menu_id",description = "제품의 고유한 id입니다")
    private Long menu_id;

    @Column(name = "category", nullable = true)
    @Schema(title = "category",description = "음료,음식,굿즈의 구분")
    private String category;

    @Column(name = "name", nullable = true)
    @Schema(title = "name",description = "제품의 이름")
    private String name;

    @Column(name = "menu_ename", nullable = true)
    @Schema(title = "제품영어이름",description = "제품의 영어이름")
    private String menu_ename;

    @Column(name = "menu_explain", nullable = true)
    @Schema(title = "제품설명",description = "제품설명")
    private String menu_explain;

    @Schema(title = "가격",description = "가격")
    @Column(name = "menu_price")
    private double menu_price;

    @Column(name = "menu_imgurl", nullable = true)
    @Schema(title = "이미지url주소",description = "이미지url주소")
    private String menu_imgurl;

    @Column(name = "menu_bannerimgurl", nullable = true)
    @Schema(title = "menu_bannerimgurl",description = "배너이미지url주소")
    private String menu_bannerimgurl;

    @Column(name = "status", nullable = false)
    @Schema(title = "status",description = "품절 여부")
    private boolean status;

    @Column(name = "price_size", nullable = true)
    @Schema(title = "price_size",description = "사이즈 추가 가격")
    private int price_size;

    @Column(name = "price_ice", nullable = true)
    @Schema(title = "price_ice",description = "아이스 추가", defaultValue = "2")
    private int price_ice;

//    @Column(name = "is_ice", nullable = true)
//    @Schema(title = "is_ice",description = "아이스 추가 여부 및 개수")
//    private int is_ice;

    @Column(name = "price_shot", nullable = true)
    @Schema(title = "price_shot",description = "샷 추가 가격", defaultValue = "0")
    private int price_shot;

    @Column(name = "price_cream", nullable = true)
    @Schema(title = "price_cream",description = "크림 추가 가격", defaultValue = "0")
    private int price_cream;

    @Column(name = "visible", nullable = false)
    @Schema(title = "visible",description = "메뉴 노출 여부", defaultValue = "true")
    private boolean visible = true;

    @Column(name = "recommend", nullable = true)
    @Schema(title = "recommend",description = "추천메뉴 여부")
    private boolean recommend;
}
