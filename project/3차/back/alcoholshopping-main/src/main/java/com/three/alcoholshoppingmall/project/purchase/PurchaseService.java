package com.three.alcoholshoppingmall.project.purchase;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.exception.BizException;
import com.three.alcoholshoppingmall.project.exception.ErrorCode;
import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.market.MarketRepository;
import com.three.alcoholshoppingmall.project.shoppingbasket.ShoppingbasketRepository;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final AlcoholRepository alcoholRepository;
    private final MarketRepository marketRepository;
    private final UserRepository userRepository;

    public List<Purchaseshow> PICKUPlist(String email) {
        List<Purchaseshow> list = new ArrayList<>();
        List<Purchase> check = purchaseRepository.Pickuplist(email);
        List<Alcohol> alcoholList = alcoholRepository.alcoholspick(email);
        List<Market> marketList = marketRepository.marketspick(email);
        for (int j = 0; j < check.size(); j++) {
            Purchase purchase = check.get(j);
            Alcohol alcohol = alcoholList.get(j);
            Market market = marketList.get(j);
            Purchaseshow purchaseshow = Purchaseshow.builder()
                    .id(purchase.getId())
                    .alcoholname(alcohol.getName())
                    .marketname(market.getMarketname())
                    .amount(purchase.getAmount())
                    .price(purchase.getPrice())
                    .delivery(purchase.getDelivery())
                    .division(purchase.getDivision())
                    .address(purchase.getAddress())
                    .purchaseday(purchase.getPurchaseday())
                    .picture(purchase.getPicture())
                    .ordernumber(purchase.getOrdernumber())
                    .build();
            list.add(purchaseshow);
        }
        return list;
    }

    public List<Purchaseshow> DELIVERYlist(String email) {
        List<Purchaseshow> list = new ArrayList<>();
        List<Purchase> check = purchaseRepository.Deliverylist(email);
        List<Alcohol> alcoholList = alcoholRepository.alcoholsdelivery(email);
        List<Market> marketList = marketRepository.marketsdelivery(email);
        for (int j = 0; j < check.size(); j++) {
            Purchase purchase = check.get(j);
            Alcohol alcohol = alcoholList.get(j);
            Market market = marketList.get(j);
            Purchaseshow purchaseshow = Purchaseshow.builder()
                    .id(purchase.getId())
                    .alcoholname(alcohol.getName())
                    .marketname(market.getMarketname())
                    .amount(purchase.getAmount())
                    .price(purchase.getPrice())
                    .delivery(purchase.getDelivery())
                    .division(purchase.getDivision())
                    .address(purchase.getAddress())
                    .purchaseday(purchase.getPurchaseday())
                    .ordernumber(purchase.getOrdernumber())
                    .picture(purchase.getPicture())
                    .build();

            list.add(purchaseshow);
        }
        return list;
    }

    public List<Purchaseshow> PICKUPlimt(String email) {
        List<Purchaseshow> list = new ArrayList<>();
        List<Purchase> check = purchaseRepository.Pickuplimt(email);
        List<Alcohol> alcoholList = alcoholRepository.alcoholspicklimt(email);
        List<Market> marketList = marketRepository.marketspicklimt(email);

        for (int j = 0; j < check.size(); j++) {
            Purchase purchase = check.get(j);
            Alcohol alcohol = alcoholList.get(j);
            Market market = marketList.get(j);

            Purchaseshow purchaseshow = Purchaseshow.builder()
                    .id(purchase.getId())
                    .ordernumber(purchase.getOrdernumber())
                    .alcoholname(alcohol.getName())
                    .marketname(market.getMarketname())
                    .amount(purchase.getAmount())
                    .price(purchase.getPrice())
                    .delivery(purchase.getDelivery())
                    .division(purchase.getDivision())
                    .address(purchase.getAddress())
                    .purchaseday(purchase.getPurchaseday())
                    .picture(purchase.getPicture())
                    .build();

            list.add(purchaseshow);
        }
        return list;
    }

    public List<Purchaseshow> DELIVERYLIMTlimt(String email) {
        List<Purchaseshow> list = new ArrayList<>();
        List<Purchase> check = purchaseRepository.Deliverylimt(email);
        List<Alcohol> alcoholList = alcoholRepository.alcoholsdeliverylimt(email);
        List<Market> marketList = marketRepository.marketsdeliverylimt(email);

        for (int j = 0; j < check.size(); j++) {
            Purchase purchase = check.get(j);
            Alcohol alcohol = alcoholList.get(j);
            Market market = marketList.get(j);

            Purchaseshow purchaseshow = Purchaseshow.builder()
                    .id(purchase.getId())
                    .ordernumber(purchase.getOrdernumber())
                    .alcoholname(alcohol.getName())
                    .marketname(market.getMarketname())
                    .amount(purchase.getAmount())
                    .price(purchase.getPrice())
                    .delivery(purchase.getDelivery())
                    .division(purchase.getDivision())
                    .address(purchase.getAddress())
                    .purchaseday(purchase.getPurchaseday())
                    .picture(purchase.getPicture())
                    .build();

            list.add(purchaseshow);
        }
        return list;
    }

    public String tosspay(TossInfo tossInfo) {

        URL url = null;
        URLConnection connection = null;
        StringBuilder responseBody = new StringBuilder();

        int orderNum = (int) (Math.random() * 99999999 + 1);

        try {
            url = new URL("https://pay.toss.im/api/v2/payments");
            connection = url.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            org.json.simple.JSONObject jsonBody = new JSONObject();
            jsonBody.put("orderNo", orderNum);
            jsonBody.put("amount", tossInfo.getPrice());
            jsonBody.put("amountTaxFree", 0);
            jsonBody.put("productDesc", tossInfo.getProductname());
            jsonBody.put("apiKey", "sk_test_w5lNQylNqa5lNQe013Nq");
            jsonBody.put("autoExecute", true);
            jsonBody.put("resultCallback", "http://threeback.hellomh.site/callback");
            jsonBody.put("retUrl", "http://localhost:3000/callback");
            jsonBody.put("retCancelUrl", "http://localhost:3000/");

            BufferedOutputStream bos = new BufferedOutputStream(connection.getOutputStream());
            bos.write(jsonBody.toJSONString().getBytes(StandardCharsets.UTF_8));
            bos.flush();
            bos.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line = null;
            while ((line = br.readLine()) != null) {
                responseBody.append(line);
            }
            br.close();
        } catch (Exception e) {
            responseBody.append(e);
        }

        return responseBody.toString();
    }

    public String buysave(User user, PurchaseDTO purchaseDTO) {
        User dbuser = userRepository.findByEmail(user.getEmail());

        if (dbuser != null) {
            Purchase purchase = Purchase.builder()
                    .ordernumber(purchaseDTO.getOrdernumber())
                    .user(dbuser)
                    .stock(purchaseDTO.getStock())
                    .amount(purchaseDTO.getAmount())
                    .price(purchaseDTO.getPrice())
                    .delivery(purchaseDTO.getDelivery())
                    .division(Division.BUY)
                    .address(purchaseDTO.getAddress())
                    .address2(purchaseDTO.getAddress2())
                    .picture(purchaseDTO.getPicture())
                    .purchaseday(LocalDate.now())
                    .build();

            purchaseRepository.save(purchase);

            return "구매내역 저장 성공";
        }else if(dbuser == null){
            throw new BizException(ErrorCode.NOTFOUNDUSER);
        }
        return "구매내역 저장 실패";
    }
}