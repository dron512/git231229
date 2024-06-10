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

    // 1. 주문 등록하기
    @Operation(summary = "주문 테이블에 담기", description = "name은 매장 이름(대구점, 서울점, 부산점, 인천점, 대전점)")
    @PostMapping("/neworder/{name}")
    public ResponseEntity neworder(@RequestBody OrderReqDto[] orderReqDto, Authentication authentication, @PathVariable String name) {
        User jwtUser = (User) authentication.getPrincipal();
        orderService.createNewOrder(orderReqDto, jwtUser, name);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이 완료되었습니다.");
    }

    // 2. 주문내역 보여주기
    @Operation(summary = "주문내역 보여주기")
    @GetMapping("/list")
    public ResponseEntity<List<Order>> orderlist(Authentication authentication) {
        User jwtUser = (User) authentication.getPrincipal();
        List<Order> orderList = orderService.orderListWithUser(jwtUser);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

}
