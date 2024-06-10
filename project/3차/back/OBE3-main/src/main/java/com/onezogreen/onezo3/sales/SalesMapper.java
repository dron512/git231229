package com.onezogreen.onezo3.sales;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SalesMapper {
    List<SaleVo> getSalesByStore(Long storeId);
    List<SaleVo> getSalesByMenu(Long storeId, Long menuId);
    List<SaleVo> getSalesByType(Long storeId, TakeInOut takeInOut);
    List<SaleVo> getSalesByMonth(Long storeId, String month);
    List<SaleVo> getDailySales(Long storeId);
}