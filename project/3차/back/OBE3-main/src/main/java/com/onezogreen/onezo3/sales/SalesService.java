package com.onezogreen.onezo3.sales;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesMapper salesMapper;

    public List<SaleVo> getSalesByStore(Long storeId) {
        return salesMapper.getSalesByStore(storeId);
    }
    public List<SaleVo> getSalesByMenu(Long storeId, Long menuId) {
        return salesMapper.getSalesByMenu(storeId, menuId);
    }
    public List<SaleVo> getSalesByType(Long storeId, TakeInOut takeInOut) {
        return salesMapper.getSalesByType(storeId, takeInOut);
    }
    public Map<String, List<SaleVo>> getMonthlySales(Long storeId, String month) {
        List<SaleVo> sales = salesMapper.getSalesByMonth(storeId, month);
        return sales.stream().collect(Collectors.groupingBy(SaleVo::getSaleDateFormatted));
    }
    public List<Map<String, Object>> getDailySales(Long storeId) {
        List<SaleVo> sales = salesMapper.getDailySales(storeId);
        Map<String, List<SaleVo>> groupedSales = sales.stream().collect(Collectors.groupingBy(SaleVo::getSaleDateFormatted));

        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<String, List<SaleVo>> entry : groupedSales.entrySet()) {
            String date = entry.getKey();
            List<SaleVo> salesList = entry.getValue();

            int totalSalesAmount = salesList.stream().mapToInt(SaleVo::getAmount).sum();
            int totalOrders = salesList.size();

            int storeSalesAmount = salesList.stream().filter(sale -> sale.getTakeInOut() == TakeInOut.EATIN).mapToInt(SaleVo::getAmount).sum();
            int storeOrders = (int) salesList.stream().filter(sale -> sale.getTakeInOut() == TakeInOut.EATIN).count();

            int takeoutSalesAmount = salesList.stream().filter(sale -> sale.getTakeInOut() == TakeInOut.TAKEOUT).mapToInt(SaleVo::getAmount).sum();
            int takeoutOrders = (int) salesList.stream().filter(sale -> sale.getTakeInOut() == TakeInOut.TAKEOUT).count();

            Map<String, Object> dailySales = new HashMap<>();
            dailySales.put("date", date);
            dailySales.put("totalSalesAmount", totalSalesAmount);
            dailySales.put("totalOrders", totalOrders);
            dailySales.put("storeSalesAmount", storeSalesAmount);
            dailySales.put("storeOrders", storeOrders);
            dailySales.put("takeoutSalesAmount", takeoutSalesAmount);
            dailySales.put("takeoutOrders", takeoutOrders);

            result.add(dailySales);
        }
        return result;
    }
}
