package com.three.alcoholshoppingmall.project.alcohol;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SortDTO {

    @Schema(title = "주류 대분류", description = "주류의 대분류를 넣어주시면 됩니다.",example = "주류의 대분류 입니다.")
    private String maincategory;

    @Schema(title = "주류 소분류", description = "주류의 소분류를 넣어주시면 됩니다.",example = "주류의 소분류 입니다.")
    private String subcategory;

    @Schema(title = "정렬법", description = "주류의 정렬법을 입력해주시변 됩니다.",example = "주류의 정렬 방식을 작성하여 주세요")
    private String type;


}
