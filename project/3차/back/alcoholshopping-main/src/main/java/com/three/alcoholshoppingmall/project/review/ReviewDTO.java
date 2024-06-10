package com.three.alcoholshoppingmall.project.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    @JsonIgnore
    private Long id;

    private Long alcoholcode;

    @JsonIgnore
    private User user;

    @NotBlank
    @Schema(title = "리뷰 글",example = "리뷰 글 입니다.")
    private String writing;

    @NotBlank
    @Min(value = 0, message = "최소 숫자는 0 입니다.")
    @Max(value = 5, message = "최대 숫자는 5 입니다.")
    @Schema(title = "평점",example = "평점 입니디.")
    private int grade;

    @Schema(title = "사진",example = "사진 입니다.")
    @JsonIgnore
    private String picture;

}
