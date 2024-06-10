package com.three.alcoholshoppingmall.project.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
@Schema(description = "review 테이블에 대한 내용입니다.")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "리뷰 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "주류 코드", description = "주류의 코드가 조인된 칼럼입니다.")
    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Alcohol alcohol;

    @Schema(title = "회원 이메일", description = "회원의 이메일을 넣는 조인된 칼럼입니다.")
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @Schema(title = "리뷰 글", description = "사용자가 작성한 리뷰 글입니다.")
    @Column(nullable = false, length = 500)
    private String writing;

    @Schema(title = "평점", description = "사용자가 매긴 평점 입니다.")
    @Min(value = 0, message = "최소 숫자는 0 입니다.")
    @Max(value = 5, message = "최대 숫자는 5 입니다.")
    @Column(nullable = false)
    private int grade;

    @Schema(title = "사진", description = "리뷰시 올린 사진 입니다.")
    private String picture;

    @Schema(title = "createDate", description = "리뷰 생성일자 입니다.")
    @CreationTimestamp
    private LocalDate createDate;


}
