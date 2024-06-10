package com.three.alcoholshoppingmall.project.shoppingbasket;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingbasketRepository extends JpaRepository<Shoppingbasket, Long> {

    @Query(value = "SELECT b.name FROM stock a\n" +
            "JOIN alcohol b ON a.code = b.code \n" +
            "WHERE a.stocknumber = :stocknumber", nativeQuery = true)
    String alcoholname(Long stocknumber);

    @Query(value = "SELECT b.* FROM stock a\n" +
            "JOIN market b ON a.marketcode = b.marketcode \n" +
            "WHERE a.stocknumber = :stocknumber", nativeQuery = true)
    String marketname(Long stocknumber);

    @Query(value = "SELECT picture FROM alcohol\n" +
            "WHERE CODE = :code",nativeQuery = true)
    String pictur(Long code);
    Shoppingbasket findByUser_Email(String email);
}
