package com.three.alcoholshoppingmall.project.purchase;


import com.three.alcoholshoppingmall.project.alcohol.AlcoholRepository;
import com.three.alcoholshoppingmall.project.alcohol.AlcoholService;
import com.three.alcoholshoppingmall.project.alcohol.Alcoholmain;
import com.three.alcoholshoppingmall.project.stock.Stock;
import com.three.alcoholshoppingmall.project.stock.StockCode;
import com.three.alcoholshoppingmall.project.stock.StockRepository;
import com.three.alcoholshoppingmall.project.user.User;
import com.three.alcoholshoppingmall.project.user.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchase")
@Tag(name = "purchase", description = "구매 페이지 입니다.")
@SecurityRequirement(name = "bearerAuth")
public class PurchaseController {


    private final PurchaseService purchaseServicce;
    private final AlcoholService alcoholService;
    private final StockRepository stockRepository;


    @GetMapping("/pickup")
    @Operation(summary = "구매내역 중 픽업 보기",
            description = "회원의 구매 내역중 픽업으로 수령을 신청한 제품을 모두 보여줍니다." +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Purchaseshow>> PICKUP() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Purchaseshow> list = purchaseServicce.PICKUPlist(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/delivery")
    @Operation(summary = "구매내역 중 배달 보기",
            description = "회원의 구매 내역중 배달로 수령을 신청한 제품을 모두 보여줍니다." +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Purchaseshow>> DELIVERY() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Purchaseshow> list = purchaseServicce.DELIVERYlist(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/pickuplimt")
    @Operation(summary = "구매내역중 픽업 최근 5개만",
            description = "회원의 구매 내역중 가장 최근에 픽업으로 수령을 신청한 제품을 5개를 보여줍니다." +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Purchaseshow>> PICKUPLIMT() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Purchaseshow> list = purchaseServicce.PICKUPlimt(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/deliverylimt")
    @Operation(summary = "구매내역중 배달 최근 5개만",
            description = "회원의 구매 내역중 가장 최근에 배달로 수령을 신청한 제품을 5개를 보여줍니다." +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Purchaseshow>> DELIVERYLIMT() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Purchaseshow> list = purchaseServicce.DELIVERYLIMTlimt(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/toss")
    @Operation(summary = "토스페이 결제",
            description = "토스페이 결제입니다. 필요한 정보 = 총가격,상품 이름")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> tosspay(@Valid @RequestBody TossInfo tossInfo) {

        String checkoutPage = purchaseServicce.tosspay(tossInfo);

        return ResponseEntity.status(HttpStatus.OK).body(checkoutPage);
    }

    @PostMapping("/stockcode")
    @Operation(summary = "스텍넘버 반환",
            description = "alcoholname 는 술의 이름 <br>" +
                    "marketname 는 매장 이름을 보내면 스텍넘버 번호 반환")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Stock> tosspay(@RequestBody StockCode stockCode) {
        System.out.println(stockCode);
        Stock stock = stockRepository.number(stockCode.getAlcoholname(), stockCode.getMarketname());
        System.out.println(stock);
        return ResponseEntity.status(HttpStatus.OK).body(stock);
    }

    @GetMapping("/algorithm")
    @Operation(summary = "내 알고리즘",
            description = "회원의 구매정보를 토대로 술을 추천 합니다. 구매 정보가 없을 경우 많이 팔린 술 3개를 추천 합니다." +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Alcoholmain>> MemberAlgorithm() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Alcoholmain> list = alcoholService.Algorithm(user.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/buysave")
    @Operation(summary = "구매 정보 저장", description = "구매내역을 DB에 저장합니다." +
            "이미지 경로, 제품명, 주문일자, 매장명, 주문번호, 주문방식, 주소, 수량, 결제금액이 필요합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> buysave(@AuthenticationPrincipal User user, @RequestBody PurchaseDTO purchaseDTO) {

        String result = purchaseServicce.buysave(user, purchaseDTO);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}