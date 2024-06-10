package com.three.alcoholshoppingmall.project.favorites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "favorites")
@Schema(description = "favorites 테이블에 대한 내용입니다.")
public class Favorites { //즐겨찾기

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "ID", description = "찜목록으로 자동으로 생성되는 칼럼입니다.")
    @JsonIgnore
    private Long id;

    @Schema(title = "회원 이메일", description = "회원의 이메일을 넣는 조인된 칼럼입니다.")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @Schema(title = "술의 코드", description = "술의 코드를 넣는 조인된 칼럼입니다.")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Alcohol alcohol;
}

