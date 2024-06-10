package com.three.alcoholshoppingmall.project.market;


import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.alcohol.Alcoholmain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketService {

    private final MarketRepository marketRepository;
    private final AlcoholRepository alcoholRepository;

    public List<Market> Marketlist(Long code) {

        List<Market> list = marketRepository.marketlist(code);


        return list;
    }

    public List<Alcoholmain> DeliveryPickup(String type) {

        List<Alcohol> alcohols = alcoholRepository.Markettype(type);
        List<Double> gaverages = alcoholRepository.Markeratingaverage(type);

        List<Alcoholmain> list = new ArrayList<>();
        int size = Math.min(alcohols.size(), gaverages.size());
        for (int i = 0; i < size; i++) {
            Alcohol alcohol = alcohols.get(i);
            Double gaverage = gaverages.get(i);

            Alcoholmain alcoholmain = Alcoholmain
                    .builder()
                    .code(alcohol.getCode())
                    .name(alcohol.getName())
                    .picture(alcohol.getPicture())
                    .price(alcohol.getPrice())
                    .ratingaverage(gaverage)
                    .build();

            list.add(alcoholmain);
        }

        return list;
    }
}
