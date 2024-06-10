package com.mh.green2nd.orders.adminOrder;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderState;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/order")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    // 주문 상태 변경
    @Operation(summary = "주문 상태 변경", description = " 주문 요청, 주문 승인, 제조 완료, 수령 완료 중 택1")
    @PutMapping("/{orderId}/state")
    public ResponseEntity<String> updateOrderState(Long orderId, OrderState newState, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminOrderService.updateOrderState(currentUser, orderId, newState);
        return ResponseEntity.ok("주문 상태가 변경되었습니다.");
    }

    // 주문 내역 조회
    @Operation(summary = "모든 주문 조회")
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        List<Order> orders = adminOrderService.getAllOrders(currentUser);
        return ResponseEntity.ok(orders);
    }

    // 모든 주문 상세 정보 조회
    @Operation(summary = "모든 주문 상세 정보 조회")
    @GetMapping("/details")
    public ResponseEntity<List<Order>> getAllOrderDetails(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        List<Order> orders = adminOrderService.getAllOrderDetails(currentUser);
        return ResponseEntity.ok(orders);
    }


}
