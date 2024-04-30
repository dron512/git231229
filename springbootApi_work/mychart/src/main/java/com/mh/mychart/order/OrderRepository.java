package com.mh.mychart.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Query("SELECT o FROM Order o JOIN FETCH o.orderItems WHERE o.orderId = :orderId")
//    Optional<Order> findOrderById(Long orderId);
}
