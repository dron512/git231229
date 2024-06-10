package com.mh.green2nd.store.adminStore;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderRepository;
import com.mh.green2nd.store.*;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import com.mh.green2nd.orders.orderitem.OrderMenu;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminStoreService {

    private final StoreRepository storeRepository;
    private final OrderRepository orderRepository;

//    // admin는 자신이 속한 매장 조회 가능
//    public StoreInfo getStoreInfo(User user) {
//        Store store = storeRepository.findByUser(user)
//                .orElseThrow(() -> new RuntimeException("Store not found"));
//
//        List<Order> orders = orderRepository.findByStoreName(store.getName());
//        Map<LocalDate, Double> salesInfo = orders.stream()
//                .collect(Collectors.groupingBy(
//                        order -> order.getCreate_time().toLocalDate(),
//                        Collectors.reducing(
//                                0.0,
//                                Order::getTotalOrderPrice,
//                                Double::sum
//                        )
//                ));
//
//        List<OrderInfo> orderInfos = orders.stream().map(order -> {
//            OrderInfo orderInfo = new OrderInfo();
//            orderInfo.setCustomerName(order.getUser().getNickname());
//            orderInfo.setTotalOrderPrice(order.getTotalOrderPrice());
//            Map<String, Integer> orderedItems = order.getOrderItems().stream()
//                    .collect(Collectors.toMap(
//                            orderMenu -> orderMenu.getMenu().getName(),
//                            OrderMenu::getQuantity,
//                            Integer::sum
//                    ));
//            orderInfo.setOrderedItems(orderedItems);
//            return orderInfo;
//        }).collect(Collectors.toList());
//
//        LocalDateTime createTime = orders.get(0).getCreate_time();
//
//        StoreInfo storeInfo = new StoreInfo(store.getName(), store.getAddress(), store.getPhone(), store.getOpen(), store.getClose(), store.getHoliday(), store.getStatus(), store.getAdminName(), salesInfo, createTime);
//        storeInfo.setOrderInfos(orderInfos);
//        return storeInfo;
//    }

    // admin만 매장 영업시간 수정 가능
    public Store updateStoreTime(User user, String name, String open, String close) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("admins만 매장 영업시간 수정 가능");
        }
        Store store = storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setOpen(open);
        store.setClose(close);
        return storeRepository.save(store);
    }

    // admin만 휴무일 수정 가능
    public Store updateStoreHoliday(User user, String name, String holiday) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("admins만 휴무일 수정 가능");
        }
        Store store = storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setHoliday(holiday);
        return storeRepository.save(store);
    }




}
