package com.mh.green2nd.orders;

import com.mh.green2nd.cart.CartService;
import com.mh.green2nd.orders.dto.OrderReqDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "주문 테이블에 담기")
    @PostMapping("/neworder")
    public ResponseEntity neworder(@RequestBody OrderReqDto[] orderReqDto, Authentication authentication) {
        User jwtUser = (User) authentication.getPrincipal();
        orderService.createNewOrder(orderReqDto, jwtUser);
        return null;
    }

    // 1. 주문내역 보여주기
    @GetMapping("/list")
    public ResponseEntity<List<Order>> orderlist(Authentication authentication) {
        User jwtUser = (User) authentication.getPrincipal();
        List<Order> orderList = orderService.orderList(jwtUser);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    // 2. 장바구니메뉴 삭제시 장바구니 총가격 수정

//    @Operation(summary = "안씀")
//    @GetMapping("/order2")
//    public ResponseEntity<List<String>> beverage(
//            MenuReq req
//    ) { // 반환 타입 변경
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if( authentication instanceof AnonymousAuthenticationToken)
//        {
//            System.out.println("일로오나");
//            return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("TOKEN 줘야지"));
//        }
//        User jwtUser = (User)authentication.getPrincipal();
//
//        System.out.println(jwtUser.getEmail());
//        System.out.println(jwtUser.getNickname());


//        System.out.println(auth);
//
//        // 비회원
//        if (auth == null || !auth.startsWith("Bearer ")) {
//            System.out.println("token 이 없습니다.");
//        // 회원
//        } else {
//            Jws<Claims> jws = tokenManager.validateToken(auth.substring("Bearer ".length()));
//            System.out.println(jws);
//
//            String email = jws.getPayload().get("email").toString();
//
//        }

//        List<String> result = orderService.viewmenu(orderDto.getP_category()); // 반환 타입 변경
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//    }


//    @Operation(summary = "장바구니에 담기")
//    @GetMapping("/menu")
//    public ResponseEntity<List<String>> beverage(@RequestBody OrderDto orderDto) { // 반환 타입 변경
//        List<String> result = orderService.viewmenu(orderDto.getP_category()); // 반환 타입 변경
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
//
//    @Operation(summary = "담지 않고 바로 결제하기")
//    @GetMapping("/pay")
//    public ResponseEntity<List<String>> beverage(@RequestBody OrderDto orderDto) { // 반환 타입 변경
//        List<String> result = orderService.viewmenu(orderDto.getP_category()); // 반환 타입 변경
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
//
//    @Operation(summary = "하트버튼 누르면 즐겨찾기로 가기")
//    @GetMapping("/menu")
//    public ResponseEntity<List<String>> beverage(@RequestBody OrderDto orderDto) { // 반환 타입 변경
//        List<String> result = orderService.viewmenu(orderDto.getP_category()); // 반환 타입 변경
//        return ResponseEntity.status(HttpStatus.OK).body(result);
//    }
}
