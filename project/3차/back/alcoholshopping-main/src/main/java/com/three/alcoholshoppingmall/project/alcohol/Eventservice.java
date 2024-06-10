package com.three.alcoholshoppingmall.project.alcohol;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Eventservice {

    private final AlcoholRepository alcoholRepository;

    public List<Alcoholmain> Most() {
        List<Alcohol> alcohols = alcoholRepository.mostsold();
        List<Double> gaverages = alcoholRepository.mostsoldgrade();

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


    public List<Alcoholmain> Rand() {
        List<Alcohol> alcohols = alcoholRepository.RAND();

        List<Alcoholmain> list = new ArrayList<>();

        for (Alcohol alcohol : alcohols) {
            List<Double> gaverage = alcoholRepository.Randgrade(alcohol.getCode());

            for (int i = 0; i < gaverage.size(); i++) {
                Alcoholmain alcoholmain = Alcoholmain
                        .builder()
                        .code(alcohol.getCode())
                        .name(alcohol.getName())
                        .picture(alcohol.getPicture())
                        .price(alcohol.getPrice())
                        .ratingaverage(gaverage.get(i))
                        .build();

                list.add(alcoholmain);
            }
        }

        return list;
    }

        //신제품
    public List<Alcoholmain> Product() {
        List<Alcohol> alcohols =  alcoholRepository.newproduct();

        List<Double> gaverages = alcoholRepository.newgrade();

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
