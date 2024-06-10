package com.mh.green2nd.cart;

import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.cart.cartMenu.CartMenuService;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
@Tag(name = "카트 컨트롤러", description = "담고 빼고 조회하고")
public class CartController {

    private final CartMenuService cartMenuService;
    private final CartService cartService;

    @Operation(summary = "카트에 물건 담기 작동 o"
            ,description = "menu_id= 몇번메뉴 quantity= 몇개 담을지 cartid = 자동생성 입력x 나머지는 옵션")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "정상적으로 담겼을 때 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "없는 메뉴아이디 들어간 경우에 나오는 코드")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartReqDto cartReqDTO, Authentication authentication) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(jwtuser);
        System.out.println(cartReqDTO);
        cartService.addToCart(cartReqDTO, (User) authentication.getPrincipal()); // 토큰과 함께 addToCart 메서드 호출
        return ResponseEntity.ok("장바구니에 담겼습니다. 확인해보세요");
    }

    // 카트에서 해당하는 항목을 삭제합니다.
    @Operation(summary = "카트의 아이템 하나 지우기 x버튼 작동 o"
            ,description = "작동은 합니다 근데 예외처리 부분에서 삭제가 안되도 삭제됐다고 하고 없는 값 넣어도 성공했다고 하고 문제가 좀 있음 일단 넣고 빼고는됨")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "정삭적으로 삭제된 경우 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "뭔가 문제가 있을 때 나오는데 명확하지 않음")
    })
    @DeleteMapping("/cartout")
    public ResponseEntity<String> removeFromCart(@RequestBody CartReqDto cartReqDTO, Authentication authentication) {
        // 현재 인증된 사용자의 정보를 가져옵니다.
        User user = (User) authentication.getPrincipal();
        // 해당 사용자의 카트에서 항목을 삭제합니다.
        cartService.removeFromCart(cartReqDTO, user);
        return ResponseEntity.ok("상품이 장바구니에서 삭제되었습니다");
    }

    @Operation(summary = "카트 물건 조회하기 작동 o"
            ,description = "토큰에서 해당 회원의 카트 가져오기 때문에 값 입력할 필요 없음 그냥 나옴")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "정상 조회됐을 때 나오는 코드"),
    })
    @GetMapping("/search")
    public ResponseEntity<List<CartMenu>> getCartItems(Authentication authentication) {
        System.out.println(authentication);
        // 현재 인증된 사용자의 정보를 가져옵니다.
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        // 현재 사용자의 장바구니 아이템을 조회합니다.
        List<CartMenu> cartItems = cartService.getCartItems(user);

        return ResponseEntity.status(HttpStatus.OK).body(cartItems);
    }

//     장바구니 아이템 수량 plus
    @Operation(summary = "장바구니 아이템 수량 플러스 작동 o"
            ,description = " +버튼 누르면 장바구니에 담긴 quantity가 증가 최대 20개")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "정삭적으로 작동하면 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "뭔가 문제가 있을 때 나오는데 명확하지 않음")
    })
    @PutMapping("/quantityplus")
    public ResponseEntity<String> quantityplus(@RequestBody CartReqDto cartReqDTO,Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        cartService.quantityplus(cartReqDTO, user);
        return ResponseEntity.ok("카트 수량 증가 완료");
    }

    //     장바구니 아이템 수량 minus
    @Operation(summary = "장바구니 아이템 수량 마이너스 작동 o"
            ,description = "0개 밑으로 뺄 수는 없음")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "정삭적으로 작동하면 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "뭔가 문제가 있을 때 나오는데 명확하지 않음")
    })
    @PutMapping("/quantityminus")
    public ResponseEntity<String> quantityminus(@RequestBody CartReqDto cartReqDTO,Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        cartService.quantityminus(cartReqDTO, user);
        return ResponseEntity.ok("카트 수량 빼기 완료");
    }

    //     장바구니 전체 비우기 <- 일단 이건 2차에 안할듯
    @Operation(summary = "장바구니 전체 비우기 작동x"
            ,description = "x")
    @DeleteMapping("/cartclear")
    public ResponseEntity<String> clearCart() {
//        cartService.clearCart();
//        return ResponseEntity.ok("Cart cleared successfully");
        return null;
    }

    @Operation(summary = "카트의 총 가격 조회하기 작동 o"
            ,description = "토큰에서 해당 회원의 카트 가져오기 때문에 값 입력할 필요 없음 그냥 나옴")
    @GetMapping("/cart/total")
    public ResponseEntity<Double> getTotalPrice(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        // 해당 사용자의 카트를 가져옵니다.
        Cart cart = cartService.getCartByUser(user);
        // 카트의 총 가격을 계산합니다.
        double totalPrice = cartService.calculateTotalCartPrice(cart);

        return ResponseEntity.ok(totalPrice);
    }
}
