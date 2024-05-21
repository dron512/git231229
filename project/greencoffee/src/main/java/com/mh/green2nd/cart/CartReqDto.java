package com.mh.green2nd.cart;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class CartReqDto {

    private Long menuId;
    @Column(columnDefinition = "integer default 1")
    private int quantity;
    private Long cartId;
//    @Enumerated(EnumType.STRING)
//    @Schema(title = "")
//    @JsonIgnore
//    @Builder.Default
//    private Resign resign = Resign.N;

    private int ice;
    private int shot;
    private int cream;
}
