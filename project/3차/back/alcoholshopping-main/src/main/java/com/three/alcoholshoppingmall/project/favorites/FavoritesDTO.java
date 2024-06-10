package com.three.alcoholshoppingmall.project.favorites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@Schema(description = "favorites 테이블에 대한 내용입니다.")
public class FavoritesDTO {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private User user;

    @JsonIgnore
    @Schema(title = "주류 code", description = "table에서 자동으로 생성되는 칼럼입니다.",example = "주류의 코드입니다.")
    private Alcohol alcohol;



}

