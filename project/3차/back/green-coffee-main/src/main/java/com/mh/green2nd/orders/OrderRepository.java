package com.mh.green2nd.orders;

import com.mh.green2nd.user.User;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.user u WHERE u.user_id = :userId")
    List<Order> findByUserIdWithUser(@Param("userId") Long userId);

    List<Order> findByStoreName(String name);

}