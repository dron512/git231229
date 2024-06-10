package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.Stock;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shoppingbasket")
@Schema(description = "shoppingbasket 테이블에 대한 내용입니다.")
public class Shoppingbasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "shoppingnumber", description = "table에서 자동으로 생성되는 칼럼입니다.")
    @JsonIgnore
    private Long shoppingnumber;

    @Schema(title = "회원 이메일", description = "회원의 이메일을 넣는 조인된 칼럼입니다.")
    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;


    @Schema(title = "date", description = "장바구니 생성 일자 입니다.")
    @CreationTimestamp
    private LocalDate Date;

}
