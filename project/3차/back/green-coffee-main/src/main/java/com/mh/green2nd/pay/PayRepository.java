package com.mh.green2nd.pay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayRepository extends JpaRepository<Pay,Long> {

    Optional<Pay> findByOrderId(String orderId);




}
