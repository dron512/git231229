package com.mh.green2nd.recommend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class RecommendService {

    private final RecommendRepository recommendRepository;

    public List<RecommendDto> getRecommendations() {
        List<Recommend> recommendations = Arrays.asList(
                new Recommend(1L, "아메리카노",5000, "image/음료/콜드 브루 커피/콜드 브루.jpg"),
                new Recommend(2L, "카페라떼",7000, "image/음료/에스프레소/바닐라 빈 라떼.jpg"),
                new Recommend(3L, "아포가토",6000, "image/푸드/아이스크림/요거트 젤라또.jpg"),
                new Recommend(4L, "치즈케이크",7000, "image/푸드/케이크/바스크 치즈 케이크.jpg"),
                new Recommend(5L, "머그컵",7000, "image/상품/머그/도도새 머그 355ml.jpg"),
                new Recommend(6L, "보온병",7000, "image/상품/보온병/JNM 하우스 보온병 480ml.jpg")
        );

        // Recommend 엔티티를 RecommendDto로 변환하여 반환
        return RecommendMapper.toRecommendDtoList(recommendations);
    }
}
