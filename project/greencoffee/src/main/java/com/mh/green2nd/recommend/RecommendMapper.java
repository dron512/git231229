package com.mh.green2nd.recommend;

import java.util.List;
import java.util.stream.Collectors;

public class RecommendMapper {

    public static RecommendDto toRecommendDto(Recommend recommend) {
        RecommendDto recommendDto = new RecommendDto();
        recommendDto.setRecommendId(recommend.getRecommendId());
        recommendDto.setRecommendName(recommend.getRecommendName());
        recommendDto.setPrice(recommend.getPrice());
        recommendDto.setImageUrl(recommend.getImageUrl());
        return recommendDto;
    }

    public static List<RecommendDto> toRecommendDtoList(List<Recommend> recommends) {
        return recommends.stream()
                .map(RecommendMapper::toRecommendDto)
                .collect(Collectors.toList());
    }
}
