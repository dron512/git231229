package com.three.alcoholshoppingmall.project.alcohol;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@DynamicInsert
public class AlcoholDto {


    @Schema(title = "주류 code", description = "table에서 자동으로 생성되는 칼럼입니다.",example = "주류의 코드입니다.")
    private Long code;

    @Schema(title = "주류 이름", description = "주류 이름을 넣어주시면 됩니다.")
    @JsonIgnore
    private String name;

    @Schema(title = "주류 대분류", description = "주류의 대분류를 넣어주시면 됩니다.")
    @JsonIgnore
    private String maincategory;

    @Schema(title = "주류 소분류", description = "주류의 소분류를 넣어주시면 됩니다.")
    @JsonIgnore
    private String subcategory;

    @Schema(title = "주류 도수", description = "주류의 도수을 넣어주시면 됩니다.")
    @JsonIgnore
    private String content;

    @Schema(title = "주류 향", description = "주류 향을 넣어주시면 됩니다.")
    @JsonIgnore
    private String aroma;

    @Schema(title = "주류 맛", description = "주류 맛을 넣어주시면 됩니다.")
    @JsonIgnore
    private String taste;

    @Schema(title = "주류 여운", description = "주류의 여운을 넣어주시면 됩니다.")
    @JsonIgnore
    private String finish;

    @Schema(title = "주류 국가", description = "주류의 국가를 넣어주시면 됩니다.")
    @JsonIgnore
    private String nation;

    @Schema(title = "주류 사진", description = "주류의 사진을 저장하는 필드입니다.")
    @JsonIgnore
    private String picture;

    @Schema(title = "주류 사진", description = "주류의 사진을 저장하는 필드입니다.")
    @JsonIgnore
    private String picture2;

    @Schema(title = "주류의 가격", description = "주류의 가격 입니다.")
    @JsonIgnore
    private int price;



}