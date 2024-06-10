package com.three.alcoholshoppingmall.project.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "search")
@Schema(description = "search 테이블에 대한 내용입니다.")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "검색 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "회원 이메일", description = "회원의 이메일을 넣는 조인된 칼럼입니다.", example = "회원 이메일")
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "email", referencedColumnName = "email", nullable = false)
    private User user;


    @Schema(title = "검색내용", description = "검색 내용을 입력하는 칼럼입니다.", example = "검색내용")
    @Column(nullable = false)
    private String searchcontents;

}