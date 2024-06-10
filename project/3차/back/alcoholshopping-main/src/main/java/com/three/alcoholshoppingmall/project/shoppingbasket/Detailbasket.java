package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.Stock;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "detailbasket")
@Schema(description = "detailbasket 테이블에 대한 내용입니다.")
public class Detailbasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "number", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long number;

    @Schema(title = "장바구니 번호", description = "장바구니 번호를 넣는 조인된 칼럼입니다.")
    @ManyToOne
    @JoinColumn(name = "shoppingnumber", referencedColumnName = "shoppingnumber")
    private Shoppingbasket shoppingbasket;

    @Schema(title = "스텍 넘버", description = "스텍(해당 술을 파는 매장)번호를 넣는 조인된 칼럼 입니다..")
    @ManyToOne
    @JoinColumn(name = "stocknumber", referencedColumnName = "stocknumber")
    private Stock stock;

    @Schema(title = "amount", description = "해당 물품의 구매 수량입니다.")
    private  int amount;

    @Schema(title = "price", description = "해당 물품들의 총 가격입니다.")
    private int price;

    @Schema(title = "배달 여부", description = "해당 매장의 배달여부 입니다")
    @Enumerated(EnumType.STRING)
    private Delivery delivery;

}
