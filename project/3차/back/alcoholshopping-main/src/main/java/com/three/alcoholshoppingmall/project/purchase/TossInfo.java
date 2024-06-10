package com.three.alcoholshoppingmall.project.purchase;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Tag(name = "TossInfo",description = "토스 결제할때 필요한 정보")
public class TossInfo {

    @NotNull(message = "가격을 적어주세요.")
    @Positive(message = "양수를 적어주세요.")
    private int price;
    @NotBlank(message = "상품명을 적어주세요.")
    private String productname;
}
