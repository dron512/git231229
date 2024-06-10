package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.exception.ErrorCode;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.market.MarketRepository;
import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.Stock;
import com.three.alcoholshoppingmall.project.stock.StockRepository;
import com.three.alcoholshoppingmall.project.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingbasketService {

    private final ShoppingbasketRepository shoppingbasketRepository;
    private final StockRepository stockRepository;
    private final AlcoholRepository alcoholRepository;
    private final DetailbasketRepository detailbasketRepository;
    private final MarketRepository marketRepository;

    public List<Shopping> Shoppinglist(String email, Delivery delivery) {
        List<Shopping> list = new ArrayList<>();

        List<Detailbasket> shoppingbaskets;
        List<String> alcoholname;
        List<Market> marketname;
        List<String> Picture;

        if (delivery.equals(Delivery.Delivery)) {
            shoppingbaskets = detailbasketRepository.DetailbasketDelivery(email);
            alcoholname = detailbasketRepository.alcoholDelivery(email);
            marketname =  marketRepository.marketDelivery(email);
            Picture = detailbasketRepository.PictureDelivery(email);
        } else {
            shoppingbaskets = detailbasketRepository.DetailbasketPickUp(email);
            alcoholname = detailbasketRepository.alcoholPickUp(email);
            marketname = marketRepository.marketPickUp(email);
            Picture = detailbasketRepository.PicturePickUp(email);
        }

        int size = shoppingbaskets.size();
        for (int i = 0; i < size; i++) {
            Detailbasket check = shoppingbaskets.get(i);
            String alcoholName = (alcoholname.size() > i) ? alcoholname.get(i) : null;
            Market market = (marketname.size() > i) ? marketname.get(i) : null;
            String picturecode = (Picture.size() > i) ? Picture.get(i) : null;
            Long alcoholcode =  alcoholRepository.code(alcoholName);


            if (alcoholName != null && alcoholName != null) {
                Shopping shopping = Shopping.builder()
                        .id(check.getNumber())
                        .stock(check.getStock().getStocknumber())
                        .name(alcoholName)
                        .alcoholcode(alcoholcode)
                        .marketname(market.getMarketname())
                        .marketaddress(market.getAddress())
                        .amount(check.getAmount())
                        .price(check.getPrice())
                        .picture(picturecode)
                        .delivery(check.getDelivery())
                        .build();

                list.add(shopping);
            }
        }
        return list;
    }

    public List<Shopping> Shopping(User user, DetailbasketDTO detailbasketDTO) {
        Detailbasket detailbasket;
        List<Shopping> list = new ArrayList<>();
        Optional<Long> stock = detailbasketRepository.stocknumbers(detailbasketDTO.getAlcoholcode(), detailbasketDTO.getMarketname());
        if (stock.isPresent()) {
            Long stocknumver = stock.get();
            Optional<Detailbasket> basket = detailbasketRepository.basket(user.getEmail(), stocknumver);
            if (basket.isEmpty()) {
                Delivery Type = detailbasketRepository.type(stocknumver);
                if (Type.equals(detailbasketDTO.getDelivery()) || Type.equals(Delivery.Delivery)) {
                    Shoppingbasket shoppingbasket = shoppingbasketRepository.findByUser_Email(user.getEmail());
                    Stock stockcheck = stockRepository.findByStocknumber(stocknumver);
                    int alcoholprice = alcoholRepository.Price(stockcheck.getAlcohol().getCode());
                    int totalprice = alcoholprice * detailbasketDTO.getAmount();

                    detailbasket = Detailbasket.builder()
                            .shoppingbasket(shoppingbasket)
                            .stock(stockcheck)
                            .amount(detailbasketDTO.getAmount())
                            .price(totalprice)
                            .delivery(detailbasketDTO.getDelivery())
                            .build();

                    detailbasketRepository.save(detailbasket);

                    String alcohol = shoppingbasketRepository.alcoholname(detailbasket.getStock().getStocknumber());
                    String market = shoppingbasketRepository.marketname(detailbasket.getStock().getStocknumber());
                    String Picture = shoppingbasketRepository.pictur(detailbasket.getStock().getAlcohol().getCode());

                    Shopping shopping = Shopping.builder()
                            .id(detailbasket.getNumber())
                            .stock(detailbasket.getStock().getStocknumber())
                            .name(alcohol)
                            .alcoholcode(detailbasketDTO.getAlcoholcode())
                            .marketname(market)
                            .amount(detailbasket.getAmount())
                            .price(detailbasket.getPrice())
                            .picture(Picture)
                            .delivery(detailbasket.getDelivery())
                            .build();

                    list.add(shopping);
                } else {
                    throw new BizException(ErrorCode.ERRORDELIVERYTYPE);
                }
            }
            if (basket.isPresent()) {
                Stock stockcheck = stockRepository.findByStocknumber(stocknumver);
                String alcohols = shoppingbasketRepository.alcoholname(stockcheck.getStocknumber());
                String market = shoppingbasketRepository.marketname(stockcheck.getStocknumber());
                String Picture = shoppingbasketRepository.pictur(stockcheck.getAlcohol().getCode());

                int alcoholprice = alcoholRepository.Price(stockcheck.getAlcohol().getCode());
                int Beforeamount = detailbasketRepository.amount(user.getEmail(), stocknumver);
                int plusamount = detailbasketDTO.getAmount() + Beforeamount;
                int plusPrice = plusamount * alcoholprice;

                Detailbasket shoppingbasketcheck = basket.get();
                shoppingbasketcheck.setPrice(plusPrice);
                shoppingbasketcheck.setAmount(plusamount);
                detailbasketRepository.save(shoppingbasketcheck);

                Shopping shopping = Shopping.builder()
                        .id(shoppingbasketcheck.getNumber())
                        .stock(stockcheck.getStocknumber())
                        .name(alcohols)
                        .alcoholcode(detailbasketDTO.getAlcoholcode())
                        .marketname(market)
                        .amount(plusamount)
                        .price(plusPrice)
                        .picture(Picture)
                        .delivery(shoppingbasketcheck.getDelivery())
                        .build();

                list.add(shopping);
            }
            return list;
        } else {
            throw new BizException(ErrorCode.ERRORDELIVERYTYPE);
        }
    }

    @Transactional
    public String Delete(Long number) {
        Optional<Detailbasket> basket = detailbasketRepository.findByNumber(number);
            if (basket.isPresent()) {
                detailbasketRepository.deleteByNumber(number);

                return ("해당이 제품이 장바구니에서 삭제되었습니다.");

            } else {
                throw new BizException(ErrorCode.NOTFOUNDSHPPING);
            }
    }

    public List<Shopping> Put(User user, ShoppingPUT shoppingPUT) {
        Optional<Long> stock = detailbasketRepository.stocknumber(shoppingPUT.getId());
        if(stock.isPresent()){
        Long stocknumber = stock.get();
        Optional<Detailbasket> basket = detailbasketRepository.basket(
                user.getEmail(), stocknumber);
        if (basket.isPresent()) {

                Stock stockcheck = stockRepository.findByStocknumber(stocknumber);
                int alcoholprice = alcoholRepository.Price(stockcheck.getAlcohol().getCode());
                int totalprice = alcoholprice * shoppingPUT.getAmount();
                Detailbasket exbasket = basket.get();
                exbasket.setAmount(shoppingPUT.getAmount());
                exbasket.setPrice(totalprice);
                detailbasketRepository.save(exbasket);
            }
        } else {
            throw new BizException(ErrorCode.NOTFOUNDSHPPING);
        }
        List<Shopping> list = new ArrayList<>();
        List<Detailbasket> shoppingbaskets = detailbasketRepository.baskets(user.getEmail());
        List<String> alcoholname = detailbasketRepository.alcohol(user.getEmail());
        List<String> marketname = detailbasketRepository.market(user.getEmail());
        List<String> Picture = detailbasketRepository.Picture(user.getEmail());

        for (int i = 0; i < shoppingbaskets.size(); i++) {
            Detailbasket check = shoppingbaskets.get(i);
            String alcoholName = alcoholname.isEmpty() ? null : alcoholname.get(i);
            String marketName = marketname.isEmpty() ? null : marketname.get(i);
            String picturecode = Picture.isEmpty() ? null : Picture.get(i);
            Long alcoholcode =  alcoholRepository.code(alcoholName);

            Shopping shopping = Shopping.builder()
                    .id(check.getNumber())
                    .stock(check.getStock().getStocknumber())
                    .name(alcoholName)
                    .alcoholcode(alcoholcode)
                    .marketname(marketName)
                    .amount(check.getAmount())
                    .price(check.getPrice())
                    .picture(picturecode)
                    .delivery(check.getDelivery())
                    .build();
            list.add(shopping);
        }
        return list;
    }
}

