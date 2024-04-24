package com.green.onezo.cart;

import com.green.onezo.member.Member;
import com.green.onezo.menu.Menu;
import com.green.onezo.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    // 장바구니에 아이템 추가
    public void addCart(Member member, Store store, Menu menu, int quantity) {
        CartItem cartItem = CartItem.builder()
                .member(member)
                .store(store)
                .menu(menu)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);
    }

    // 장바구니 아이템 조회
    public List<CartItem> getCartItems(Member member) {
        return cartRepository.findByMember(member);
    }

    // 장바구니 아이템 수량 조절
    public void updateQuantity(Long cartItemId, int quantity) {
        Optional<Cart> optionalCartItem = cartRepository.findById(cartItemId);
        optionalCartItem.ifPresent(cartItem -> {
            cartItem.setQuantity(quantity);
            cartRepository.save(cartItem);
        });
    }

    // 장바구니 아이템 삭제
    public void deleteCartItem(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    // 장바구니 총 결제 금액 계산
    public int totalPay(Member member) {
        List<CartItem> cartItems = cartRepository.findByMember(member);
        int totalPay = 0;
        for (CartItem cartItem : cartItems) {
            totalPay += cartItem.getMenu().getPrice() * cartItem.getQuantity();
        }
        return totalPay;
    }
}