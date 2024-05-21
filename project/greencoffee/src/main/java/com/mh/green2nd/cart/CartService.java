package com.mh.green2nd.cart;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.cart.cartMenu.CartMenuRepository;
import com.mh.green2nd.cart.cartMenu.CartMenuService;
import com.mh.green2nd.jwt.TokenManager;
import com.mh.green2nd.menu.Menu;
import com.mh.green2nd.menu.MenuRepository;
import com.mh.green2nd.user.User;
import com.mh.green2nd.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class CartService {

    // 카트 레포지토리와 유저 레포지토리를 주입합니다.
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final CartMenuRepository cartMenuRepository;
    private final CartMenuService cartMenuService;
    private final TokenManager tokenManager;

    @Transactional
    // 카트에 메뉴를 추가합니다.
    public CartResDto addToCart(CartReqDto cartReqDTO, User user) {
        // 사용자 이메일로 사용자 정보 가져오기
        User dbuser = userRepository.findByEmail(user.getEmail());

        // 해당되는 메뉴 ID로 메뉴 검색
        Menu menu = menuRepository.findById(cartReqDTO.getMenuId())
                .orElseThrow(
                        () -> new EntityNotFoundException("그런메뉴 id 없습니다: "
                                + cartReqDTO.getMenuId()));

        // 사용자의 카트 가져오기
        Cart cart = cartRepository.findByUser(dbuser).orElse(new Cart());
        if (cart.getCartMenusList().isEmpty()) {
            cart.setUser(dbuser);
        }

        // 카트에 이미 존재하는 메뉴인지 확인하고 업데이트 또는 추가
        CartMenu existingCartMenu = cart.getCartMenusList().stream()
                .filter(cartMenu -> cartMenu.getMenu().equals(menu))
                .findFirst()
                .orElse(null);

        if (existingCartMenu != null) {
            // 이미 카트에 있는 메뉴의 수량 업데이트
            existingCartMenu.setQuantity(existingCartMenu.getQuantity() + cartReqDTO.getQuantity());
        } else {
            // 새로운 메뉴를 카트에 추가
            CartMenu cartMenu = new CartMenu();
            cartMenu.setMenu(menu);
            cartMenu.setQuantity(cartReqDTO.getQuantity());
            cartMenu.setCart(cart);
            //
            cartMenu.setIce(cartReqDTO.getIce());
            cartMenu.setShot(cartReqDTO.getShot());
            cartMenu.setCream(cartReqDTO.getCream());
            //
            cart.getCartMenusList().add(cartMenu);
        }

        // totalPrice 업데이트
        double extraPrice = cartReqDTO.getIce() * 200 + cartReqDTO.getShot() * 500 + cartReqDTO.getCream() * 500;
        cart.addToTotalCartPrice((menu.getMenu_price() + extraPrice) * cartReqDTO.getQuantity());

        // 카트 저장
        cartRepository.save(cart);

        // 결과 생성
        CartResDto cartResDto = new CartResDto();
        // 여기에 적절한 결과값 설정
        return cartResDto;
    }

    // 카트에서 해당하는 항목을 삭제합니다.

//    public List<CartMenu> search(CartReqDto cartReqDTO,User user) {
//    Cart cart = cartRepository.findByUser(user)
//        .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + user.getEmail()));
//
//    return cart.getCartMenusList();
//}

    public List<CartMenu> getCartItems(User user) {
        User dbUser = userRepository.findByEmail(user.getEmail());

        // 사용자의 ID를 기반으로 해당 사용자의 장바구니 아이템을 조회합니다.
        Optional<Cart> optionalCart = cartRepository.findByUser(dbUser);

        // 만약 optionalCart가 비어있다면 빈 리스트를 반환합니다.
        if (optionalCart.isEmpty()) {
            return Collections.emptyList();
        }

        // Optional에서 Cart 객체를 가져옵니다.
        Cart cart = optionalCart.get();

        // Cart 객체에서 장바구니 아이템 목록을 가져옵니다.
        List<CartMenu> cartItems = cart.getCartMenusList();

        return cartItems;
    }

    @Transactional
    public void removeFromCart(CartReqDto cartReqDto, User user) {
        User dbUser = userRepository.findById(user.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + user.getUser_id()));

//        System.out.println(dbUser);
        // 사용자의 카트 가져오기
        Cart cart = cartRepository.findByUser(dbUser)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + dbUser.getUser_id()));

        // 카트에서 해당 메뉴를 찾습니다.
        System.out.println("삭제전 " + cart.getCartMenusList().size());
        // 카트에서 해당 메뉴를 찾습니다.
        cart.getCartMenusList().forEach(cartMenu -> {
            System.out.println("cartMenu.getMenu().getMenu_id() " + cartMenu.getMenu().getMenu_id());
            System.out.println("cartReqDto.getMenuId() " + cartReqDto.getMenuId());
            // 메뉴 아이디가 같다면 삭제합니다.
            if (cartMenu.getMenu().getMenu_id().equals(cartReqDto.getMenuId())) {
                System.out.println("삭제하러와쌴");
                System.out.println(cartMenu.getCartmenu_id());
                // 카트에서 해당 메뉴를 삭제합니다.
                cartMenuRepository.deleteById(cartMenu.getCartmenu_id());
            }
        });
        // 카트에서 해당 메뉴를 찾습니다.
        cart.getCartMenusList().removeIf(
                // 메뉴 아이디가 같다면 삭제합니다.
                cartMenu -> cartMenu.getMenu().getMenu_id().equals(cartReqDto.getMenuId()));

        // 카트에서 해당 메뉴를 찾습니다.
        System.out.println("삭제후 " + cart.getCartMenusList().size());
        // 장바구니의 총 가격을 다시 계산합니다.
        int total = cart.getCartMenusList().stream().mapToInt(
                // 장바구니에 담긴 메뉴의 가격을 계산합니다.
                cartMenu ->{
                    // 메뉴의 가격과 수량을 곱한 값을 반환합니다.
                        return (cartMenu.getQuantity()+ cartMenu.getIce()*200+cartMenu.getShot()*500+ cartMenu.getCream()*500);
                }
                // 모든 메뉴의 가격을 더합니다.
        ).sum();
        cart.setTotalCartPrice(total);
//        // 장바구니를 저장합니다.
        cartRepository.save(cart);
    }

    // 카트에서 해당 메뉴의 수량을 증가시킵니다.
    public void quantityplus(CartReqDto cartReqDTO, User user) {
        // 사용자의 ID, 메뉴의 ID, dbUser를 기반으로 사용자, 메뉴 정보를 가져옵니다.
        User dbUser = userRepository.findById(user.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + user.getUser_id()));
        Menu menu = menuRepository.findById(cartReqDTO.getMenuId())
                .orElseThrow(() -> new EntityNotFoundException("그런메뉴 id 없습니다: " + cartReqDTO.getMenuId()));
        Cart cart = cartRepository.findByUser(dbUser)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + dbUser.getUser_id()));
        // 카트에서 해당 메뉴를 찾습니다.
        CartMenu cartMenu = cart.getCartMenusList().stream()
                .filter(cm -> cm.getMenu().getMenu_id().equals(menu.getMenu_id()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Menu not found in cart: " + menu.getMenu_id()));
        if (cartMenu.getQuantity() >= 20) {
            throw new IllegalArgumentException("20개 이상 담아서 더 이상 담을 수 없습니다");
        }
        cartMenu.setQuantity(cartMenu.getQuantity() + 1);
        cartRepository.save(cart);
    }

    // 카트에서 해당 메뉴의 수량을 감소시킵니다.
    public void quantityminus(CartReqDto cartReqDTO, User user) {
        User dbUser = userRepository.findById(user.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + user.getUser_id()));
        Menu menu = menuRepository.findById(cartReqDTO.getMenuId())
                .orElseThrow(() -> new EntityNotFoundException("그런메뉴 id 없습니다: " + cartReqDTO.getMenuId()));
        Cart cart = cartRepository.findByUser(dbUser)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + dbUser.getUser_id()));
        // 카트에서 해당 메뉴를 찾습니다.
        CartMenu cartMenu = cart.getCartMenusList().stream()
                .filter(cm -> cm.getMenu().getMenu_id().equals(menu.getMenu_id()))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Menu not found in cart: " + menu.getMenu_id()));
        if (cartMenu.getQuantity() <= 0) {
            throw new IllegalArgumentException("0개 밑으로 뺄 수 없습니다.");
        }
        cartMenu.setQuantity(cartMenu.getQuantity() - 1);
        cartRepository.save(cart);
    }

    public void clearCart(User user) {
        Cart cart = getCartByUser(user);
        cart.clearItems(); // assuming Cart has a clearItems method
        saveCart(cart); // assuming CartService has a saveCart method
    }
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    // 현재 인증된 사용자의 카트를 가져옵니다.
    public Cart getCartByUser(User user) {
        User dbUser = userRepository.findByEmail(user.getEmail());
        Cart cart = cartRepository.findByUser(dbUser)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + dbUser.getUser_id()));
        return cart;
    }
    public double calculateTotalCartPrice(Cart cart) {
        double totalPrice = 0.0;
        for (CartMenu cartMenu : cart.getCartMenusList()) {
            double subPrice = cartMenuService.calculateSubCartPrice(cartMenu);
            totalPrice += subPrice;
        }
        return totalPrice;
    }
}
