package com.three.alcoholshoppingmall.project.alcohol;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "상세 페이지용 정보저장 클래스")
public class DetailInformation {


    @Schema(title = "주류 code", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long code;

    @Schema(title = "주류 이름", description = "주류 이름을 넣어주시면 됩니다.")
    private String name;

    @Schema(title = "주류의 평균 평점", description = "주류의 평균 평점 입니다.")
    private double ratingaverage;

    @Schema(title = "주류의 가격", description = "주류의 가격 입니다.")
    private int price;

    @Schema(title = "주류 대분류", description = "주류의 대분류를 넣어주시면 됩니다.")
    private String maincategory;

    @Schema(title = "주류 소분류", description = "주류의 소분류를 넣어주시면 됩니다.")
    private String subcategory;

    @Schema(title = "주류 도수", description = "주류의 도수을 넣어주시면 됩니다.")
    private String content;

    @Schema(title = "주류 향", description = "주류 향을 넣어주시면 됩니다.")
    private String aroma;

    @Schema(title = "주류 맛", description = "주류 맛을 넣어주시면 됩니다.")
    private String taste;

    @Schema(title = "주류 여운", description = "주류의 여운을 넣어주시면 됩니다.")
    private String finish;

    @Schema(title = "주류 국가", description = "주류의 국가를 넣어주시면 됩니다.")
    private String nation;

    @Schema(title = "주류 사진", description = "주류의 사진")
    private String picture;

    @Schema(title = "주류 사진", description = "주류의 사진")
    private String picture2;

    @Schema(title = "리뷰 갯수", description = "선택한 술의 리뷰 갯수 입니다.")
    private int reviewcacount;


}
