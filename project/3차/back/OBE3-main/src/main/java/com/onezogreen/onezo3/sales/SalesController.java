package com.onezogreen.onezo3.sales;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService saleService;


    @Operation(summary = "매장의 매출 조회", description = "로그인한 사용자의 매장의 전체 매출을 조회합니다.")
    @GetMapping("/store")
    public List<SaleVo> getSalesByStore(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return saleService.getSalesByStore(storeId);
    }

    @Operation(summary = "매장의 메뉴별 매출 조회",
            description = "로그인한 사용자의 매장의 특정 메뉴의 매출을 조회합니다.")
    @GetMapping("/store/menu/{menuId}")
    public List<SaleVo> getSalesByMenu(Authentication authentication, @PathVariable Long menuId) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return saleService.getSalesByMenu(storeId, menuId);
    }

    @Operation(summary = "매장의 주문 유형별 매출 조회",
            description = "로그인한 사용자의 매장의 특정 주문 유형의 매출을 조회합니다.")
    @GetMapping("/store/type/{takeInOut}")
    public List<SaleVo> getSalesByType(Authentication authentication, @PathVariable TakeInOut takeInOut) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return saleService.getSalesByType(storeId, takeInOut);
    }

    @Operation(summary = "매장의 월별 매출 조회",
            description = "로그인한 사용자의 매장의 월별 매출을 조회합니다.")
    @GetMapping("/store/monthly")
    public Map<String, List<SaleVo>> getMonthlySales(Authentication authentication, @RequestParam String month) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return saleService.getMonthlySales(storeId, month);
    }
    @Operation(summary = "매장의 일별 매출 조회", description = "로그인한 사용자의 매장의 일별 매출을 조회합니다.")
    @GetMapping("/store/daily")
    public List<Map<String, Object>> getDailySales(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return saleService.getDailySales(storeId);
    }
}