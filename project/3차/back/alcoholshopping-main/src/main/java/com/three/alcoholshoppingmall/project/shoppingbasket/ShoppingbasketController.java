package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.StockCode;
import com.three.alcoholshoppingmall.project.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shoppingbasket")
@Tag(name = "Shoppingbasket", description = "장바구니 입니다.")
@SecurityRequirement(name = "bearerAuth")
public class ShoppingbasketController {

    private final ShoppingbasketService shoppingbasketService;
    private final DetailbasketRepository detailbasketRepository;

    @GetMapping("/delivery")
    @Operation(summary = "장바구니 배달 조회",
            description = "현재 장바구니에 넣은 물건중 배달들만 조회하는 기능입니다. <br>" +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Shopping>> Shoppingdelivery() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Delivery delivery = Delivery.Delivery;
        List<Shopping> list = shoppingbasketService.Shoppinglist(user.getEmail(), delivery);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/pickup")
    @Operation(summary = "장바구니 픽업 조회",
            description = "현재 장바구니에 넣은 물건중 픽업들만 조회하는 기능입니다. <br>" +
                    "입력 하실 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Shopping>> ShoppingpickUp() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Delivery delivery = Delivery.PickUp;
        List<Shopping> list = shoppingbasketService.Shoppinglist(user.getEmail(), delivery);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("")
    @Operation(summary = "장바구니 넣기",
            description = "해당 재품을 회원의 장바구니에 추가하는 기능 입니다. <br>" +
                    "alcoholcode의 입력이 필요 합니다 alcoholcode은 술의 고유코드입니다. <br>" +
                    "marketname의 입략이 필요합니다. marketname은 매장의 이름입니다. <br>" +
                    "amount 물건의 수량의 입력이 필요 합니다. <br>" +
                    "delivery는 물건을 받는 법 입니다 PickUp,Delivery의 입력이 필요합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Shopping>> Shopping(@RequestBody DetailbasketDTO detailbasketDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Shopping> list = shoppingbasketService.Shopping(user, detailbasketDTO);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("")
    @Operation(summary = "장바구니 빼기",
            description = "해당 재품을 회원의 장바구니에서 뺴는 기능입니다. <br>" +
                    "id의 입력이 필요합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<String> DeleteShopping(@RequestBody ShoppingDELETE shoppingDELETE) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        String list = shoppingbasketService.Delete(shoppingDELETE.getId());

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/all")
    @Operation(summary = "장바구니 물건 전부 빼기",
            description = "해당 재품을 회원의 장바구니에서 물건을 전부 뺴는 기능입니다. <br>" +
                    "입력 값은 없습니다.")
    @SecurityRequirement(name = "bearerAuth")
    @Transactional
    public ResponseEntity<String> DeleteShopping() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Optional<Integer> baskets = detailbasketRepository.basketcheck(user.getEmail());
        if (baskets.isPresent() && baskets.get() != 0) {
            detailbasketRepository.deldeteall(user.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body("장바구니의 물건을 전부 삭제 하였습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("장바구니가 이미 비어 있습니다.");
        }
    }

    @PutMapping("")
    @Operation(summary = "장바구니 수정",
            description = "회원의 장바구니에서 선택한 제품의 수량을 수정하는 기능입니다.<br>" +
                    "id의 입력이 필요합니다." +
                    "amount 물건의 수량의 입력이 필요 합니다.")
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<List<Shopping>> PutShopping(@RequestBody ShoppingPUT shoppingPUT) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        List<Shopping> list = shoppingbasketService.Put(user, shoppingPUT);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
