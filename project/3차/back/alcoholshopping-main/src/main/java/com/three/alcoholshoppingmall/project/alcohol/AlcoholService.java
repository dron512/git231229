package com.three.alcoholshoppingmall.project.alcohol;



import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.exception.ErrorCode;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.market.MarketRepository;
import com.three.alcoholshoppingmall.project.market.Marketinfo;
import com.three.alcoholshoppingmall.project.purchase.Purchase;
import com.three.alcoholshoppingmall.project.purchase.PurchaseRepository;
import com.three.alcoholshoppingmall.project.review.ReviewRepository;
import com.three.alcoholshoppingmall.project.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AlcoholService {

    private final AlcoholRepository alcoholRepository;
    private final ReviewRepository reviewRepository;
    private final AlgorithmRepository algorithmRepository;
    private final PurchaseRepository purchaseRepository;
    private final MarketRepository marketRepository;
    private final StockRepository stockRepository;


    public List<DetailInformation> DetailPage(AlcoholDto alcoholDto) {

        Double ratings = alcoholRepository.Rating(alcoholDto.getCode());
        int reviewCount = reviewRepository.Reviewcacount(alcoholDto.getCode());

        Optional<Alcohol> alcohols = alcoholRepository.findByCode(alcoholDto.getCode());
        if(alcohols.isPresent()) {
            Alcohol alcohol = alcohols.get();
            List<DetailInformation> list = new ArrayList<>();

            DetailInformation info = DetailInformation.builder()
                    .code(alcohol.getCode())
                    .name(alcohol.getName())
                    .maincategory(alcohol.getMaincategory())
                    .subcategory(alcohol.getSubcategory())
                    .content(alcohol.getContent())
                    .aroma(alcohol.getAroma())
                    .taste(alcohol.getTaste())
                    .finish(alcohol.getFinish())
                    .nation(alcohol.getNation())
                    .picture(alcohol.getPicture())
                    .picture2(alcohol.getPicture2())
                    .price(alcohol.getPrice())
                    .ratingaverage(ratings)
                    .reviewcacount(reviewCount)
                    .build();

            list.add(info);

            return list;
        }
        else {
            throw new BizException(ErrorCode.NOTFOUNDALCOHOL);
        }
    }

    public List<Alcoholmain> MainType(String maincategory, String type) {
        List<Alcohol> alcohols;
        List<Double> ratings;
        switch (type) {
            case "인기":
                alcohols = alcoholRepository.popmain(maincategory);
                ratings = alcoholRepository.popratingsmain(maincategory);
                break;
            case "높은 가격":
                alcohols = alcoholRepository.maxmain(maincategory);
                ratings = alcoholRepository.maxratingsmain(maincategory);
                break;
            case "낮은 가격":
                alcohols = alcoholRepository.minmain(maincategory);
                ratings = alcoholRepository.minratingsmain(maincategory);
                break;
            default:
                throw new BizException(ErrorCode.ERRORTYPE);
        }

        List<Alcoholmain> list = new ArrayList<>();

        for (int i = 0; i < alcohols.size(); i++) {
            Alcohol alcohol = alcohols.get(i);
            Double grade = (i < ratings.size()) ? ratings.get(i) : null;

            Alcoholmain alcoholmain = Alcoholmain.builder()
                    .code(alcohol.getCode())
                    .name(alcohol.getName())
                    .price(alcohol.getPrice())
                    .picture(alcohol.getPicture())
                    .ratingaverage(grade)
                    .build();

            list.add(alcoholmain);
        }

        return list;
    }


    public List<Alcoholmain> Algorithm(String email) {
        Optional<Purchase> check = purchaseRepository.findByEmail(email);
        List<Alcohol> alcohols;

        if (check.isPresent()) {
            String aroma = algorithmRepository.Aroma(email);
            String taste = algorithmRepository.Taste(email);
            String finish = algorithmRepository.Finish(email);
            alcohols = algorithmRepository.personalalgorithm(aroma, taste, finish);
        } else {
            alcohols = alcoholRepository.mostsold();
        }

        List<Double> gaverages = alcoholRepository.mostsoldgrade();

        return mapAlcoholsToAlcoholMains(alcohols, gaverages);
    }

    private List<Alcoholmain> mapAlcoholsToAlcoholMains(List<Alcohol> alcohols, List<Double> gaverages) {
        List<Alcoholmain> list = new ArrayList<>();
        int size = Math.min(alcohols.size(), gaverages.size());
        for (int i = 0; i < size; i++) {
            Alcohol alcohol = alcohols.get(i);
            Double gaverage = gaverages.get(i);

            Alcoholmain alcoholmain = Alcoholmain.builder()
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


    public List<Alcoholmain> SubType(String subcategory, String type) {
        List<Alcohol> alcohols;
        List<Double> ratings;

        switch (type) {
            case "인기":
                alcohols = alcoholRepository.popsub(subcategory);
                ratings = alcoholRepository.popratingssub(subcategory);
                break;
            case "높은 가격":
                alcohols = alcoholRepository.maxsub(subcategory);
                ratings = alcoholRepository.maxratingssub(subcategory);
                break;
            case "낮은 가격":
                alcohols = alcoholRepository.minsub(subcategory);
                ratings = alcoholRepository.minratingssub(subcategory);
                break;
            default:
                throw new BizException(ErrorCode.ERRORTYPE);
        }
        List<Alcoholmain> list = new ArrayList<>();

        for (int i = 0; i < alcohols.size(); i++) {
            Alcohol alcohol = alcohols.get(i);
            Double grade = (i < ratings.size()) ? ratings.get(i) : null;

            Alcoholmain alcoholmain = Alcoholmain
                    .builder()
                    .code(alcohol.getCode())
                    .name(alcohol.getName())
                    .price(alcohol.getPrice())
                    .picture(alcohol.getPicture())
                    .ratingaverage(grade)
                    .build();

            list.add(alcoholmain);
        }

        return list;
    }

    public List<Marketinfo> MarketDetail(AlcoholDto alcoholDto) {

        List<Market> market = marketRepository.marketlist(alcoholDto.getCode());
        List<Integer> number = stockRepository.code(alcoholDto.getCode());

        List<Marketinfo> list = new ArrayList<>();

        for (int i = 0; i <  market.size(); i++) {
            Market marketcode = market.get(i);
            int code = number.get(i);

            Marketinfo marketinfo = Marketinfo
                    .builder()
                    .marketcode(marketcode.getMarketcode())
                    .marketname(marketcode.getMarketname())
                    .address(marketcode.getAddress())
                    .phonenumber(marketcode.getPhonenumber())
                    .delivery(marketcode.getDelivery())
                    .stocknumber(code)
                    .opentime(marketcode.getOpentime())
                    .closetime(marketcode.getClosetime())
                    .build();


            list.add(marketinfo);
        }
        return list;

    }
}