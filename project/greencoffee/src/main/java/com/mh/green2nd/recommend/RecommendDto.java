package com.mh.green2nd.recommend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecommendDto {
    private Long recommendId;
    private String recommendName;
    private int price;
    private String imageUrl;
}
