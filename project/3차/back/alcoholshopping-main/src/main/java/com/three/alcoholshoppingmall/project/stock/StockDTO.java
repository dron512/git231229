package com.three.alcoholshoppingmall.project.stock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.market.Market;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StockDTO {

    @JsonIgnore
    private Long stocknumber;

    private Long alcohol;

    private Long market;

    @JsonIgnore
    private int amount;

}
