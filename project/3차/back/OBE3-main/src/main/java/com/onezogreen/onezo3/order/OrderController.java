package com.onezogreen.onezo3.order;

import com.onezogreen.onezo3.exception.BizException;
import com.onezogreen.onezo3.exception.ErrorCode;
import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


    @GetMapping("/store")
    @Operation(summary = "매장의 모든 주문 조회", description = "로그인한 사용자의 매장의 모든 주문을 조회합니다.")
    public List<OrderVo> getOrdersByStore(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        List<OrderVo> orderList = orderService.getOrdersByStore(storeId);
        if (orderList == null || orderList.isEmpty()) {
            throw new BizException(ErrorCode.NOTSELECT);
        }
        return orderList;
    }


    @GetMapping("/store/{status}")
    @Operation(summary = "매장의 주문 상태별 조회", description = "로그인한 사용자의 매장의 특정 상태의 주문을 조회합니다.")
    public List<OrderVo> getOrdersByStatus(@PathVariable OrderStatus status, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        List<OrderVo> orderList = orderService.getOrdersByStatus(storeId, status);
        if (orderList == null || orderList.isEmpty()) {
            throw new BizException(ErrorCode.NOTSELECT);
        }
        return orderList;
    }

    @PutMapping("/accept/{orderId}")
    @Operation(summary = "주문 수락", description = "주문 ID를 받아서 해당 주문을 '조리중' 상태로 변경합니다.")
    public boolean acceptOrder(@PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        boolean check = orderService.acceptOrder(storeId, orderId);
        if (!check) {
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return check;
    }


    @PutMapping("/reject/{orderId}")
    @Operation(summary = "주문 거절", description = "주문 ID를 받아서 해당 주문을 '거절됨' 상태로 변경합니다.")
    public boolean rejectOrder(@PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        boolean check = orderService.rejectOrder(storeId, orderId);
        if (!check) {
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return check;
    }


    @PutMapping("/complete/{orderId}")
    @Operation(summary = "주문 완료", description = "주문 ID를 받아서 해당 주문을 '조리완료' 상태로 변경합니다.")
    public boolean completeOrder(@PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        boolean check = orderService.completeOrder(storeId, orderId);
        if (!check) {
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return check;
    }

    @PutMapping("/cancel/{orderId}")
    @Operation(summary = "주문 취소", description = "주문 ID를 받아서 해당 주문을 '취소됨' 상태로 변경합니다.")
    public boolean cancelOrder(@PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        boolean check = orderService.cancelOrder(storeId, orderId);
        if (!check) {
            throw new BizException(ErrorCode.UPDATEFAIL);
        }
        return check;

    }

}
