package com.mh.green2nd.menu;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "menu")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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

    @Column(name = "menu_origin", nullable = true)
    @Schema(title = "제품원산지",description = "제품원산지")
    private String menu_origin;

    @Schema(title = "가격",description = "가격")
    @Column(name = "menu_price")
//    @Column(name = "menu_price" ,columnDefinition = "integer default 5,000")
    private double menu_price;

    @Column(name = "menu_imgurl", nullable = true)
    @Schema(title = "이미지url주소",description = "이미지url주소")
    private String menu_imgurl;

    @Column(name = "menu_bannerimgurl", nullable = true)
    @Schema(title = "menu_bannerimgurl",description = "배너이미지url주소")
    private String menu_bannerimgurl;

}
