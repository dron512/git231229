package com.green.onezo.cart;

import com.green.onezo.member.Member;
import com.green.onezo.member.MemberService;
import com.green.onezo.menu.Menu;
import com.green.onezo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartService cartService;
    private final MemberService memberService;

    // 장바구니에 아이템 추가 (매장 선택 O)
    @PostMapping("/cart/add/{storeId}")
    public ResponseEntity<String> addCart(Member memberId, Store storeId, Menu menuId, int quantity) {
        cartService.addCart(memberId,storeId,menuId,quantity); // ???
        return new ResponseEntity<>("메뉴 담기 성공", HttpStatus.OK);
    }

    // 장바구니에 아이템 추가(매장 선택 X)
    @PostMapping("/cart/add")
    public ResponseEntity<String> addCart(Member memberId, Menu menuId, int quantity) {
        cartService.addCart(memberId,null,menuId,quantity);
        return new ResponseEntity<>("메뉴 담기 성공", HttpStatus.OK);
    }


    // 장바구니 아이템 조회
    @GetMapping("/cart/items")
    public ResponseEntity<List<CartItem>> getCartItems(Member memberId) {
        List<CartItem> cartItems = cartService.getCartItems(memberId);
        return new ResponseEntity<>(cartItems,HttpStatus.OK);
    }

    // 장바구니 아이템 수량 조절
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<String> updateQuantity(@PathVariable Long cartItemId, int quantity) {
        cartService.updateQuantity(cartItemId, quantity);
        return new ResponseEntity<>("수량 업뎃 성공", HttpStatus.OK);
    }

    // 장바구니 아이템 삭제
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Long cartItemId) {
        cartService.deleteCartItem(cartItemId);
        return new ResponseEntity<>("아이템 삭제 성공", HttpStatus.OK);
    }

    // 장바구니 총 결제 금액 조회
    @GetMapping("/cart/total-pay")
    public ResponseEntity<Integer> totalPay(Member memberId) {
        int totalPay = cartService.totalPay(memberId);
        return new ResponseEntity<>(totalPay,HttpStatus.OK);
    }
}



