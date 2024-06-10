package com.three.alcoholshoppingmall.project.refund;

import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.purchase.Division;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "refund")
@Schema(description = "환불 테이블에 대한 내용입니다.")
public class Refund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "주류 ID", description = "table에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Schema(title = "nickname", description = "회원의 nickname입니다.")
    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Schema(title = "구매, 환불, 교환 여부", description = "구매자의 상품의 상태를 표기 합니다")
    private Division division;

    @Schema(title = "가격", description = "물건의 가격입니다")
    private int price;

    @Schema(title = "수령형식", description = "물건을 수령할때 배달인지 픽업인지 구분합니다.")
    @Enumerated(EnumType.STRING)
    private Delivery delivery;

    @Schema(title = "술 이름", description = "술의 이름 입니다.")
    private String name;

    @Schema(title = "매장 이름", description = "매장의 이름 입니다.")
    private String marketname;

    @Schema(title = "이메일", description = "구매자의 이에일 주소 입니다.")
    private String email;

    @Schema(title = "OrderNumber", description = "구매자의 주문번호 입니다.")
    private String OrderNumber;

    @Schema(title = "amount", description = "해당 물품의 구매 수량입니다.")
    private  int amount;


}
