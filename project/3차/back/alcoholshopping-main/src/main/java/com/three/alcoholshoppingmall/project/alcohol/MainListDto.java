package com.three.alcoholshoppingmall.project.alcohol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MainListDto {
    @Schema(description = "주류 번호", example = "주류 번호")
    private Long code;
    @Schema(description = "주류 이름", example = "주류 이름")
    private String name;
    @Schema(description = "주류 가격", example = "주류 가격")
    private int price;
    @Schema(description = "평균평점", example = "평균평점")
    private double ratingaverage;
    @Schema(description = "주류 이미지", example = "주류 이미지")
    private String picture;
}
