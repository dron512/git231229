package com.three.alcoholshoppingmall.project.alcohol;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "alcohol")
@Schema(description = "alcohol 테이블에 대한 내용입니다.")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "주류 code", description = "table에서 자동으로 생성되는 칼럼입니다.")
    @Column(unique = true,nullable = false, length = 100)
    private Long code;

    @Schema(title = "주류 이름", description = "주류 이름을 넣어주시면 됩니다.")
    @Column(nullable = false)
    private String name;

    @Schema(title = "주류 대분류", description = "주류의 대분류를 넣어주시면 됩니다.")
    @Column(nullable = false, length = 30)
    private String maincategory;

    @Schema(title = "주류 소분류", description = "주류의 소분류를 넣어주시면 됩니다.")
    @Column(nullable = false, length = 50)
    private String subcategory;

    @Schema(title = "주류 도수", description = "주류의 도수을 넣어주시면 됩니다.")
    @Column(length = 10)
    private String content;

    @Schema(title = "주류 향", description = "주류 향을 넣어주시면 됩니다.")
    @Column(length = 100)
    private String aroma;

    @Schema(title = "주류 맛", description = "주류 맛을 넣어주시면 됩니다.")
    @Column(length = 100)
    private String taste;

    @Schema(title = "주류 여운", description = "주류의 여운을 넣어주시면 됩니다.")
    @Column(length = 100)
    private String finish;


    @Schema(title = "주류 국가", description = "주류의 국가를 넣어주시면 됩니다.")
    private String nation;

    @Schema(title = "주류 사진", description = "주류의 사진을 저장하는 필드입니다.")
    private String picture;

    @Schema(title = "주류 사진", description = "주류의 사진을 저장하는 필드입니다.")
    private String picture2;

    @Schema(title = "주류의 가격", description = "주류의 가격 입니다.")
    private int price;


}