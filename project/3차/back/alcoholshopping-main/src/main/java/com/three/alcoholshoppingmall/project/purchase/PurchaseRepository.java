package com.three.alcoholshoppingmall.project.purchase;

import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import com.three.alcoholshoppingmall.project.market.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    //해당 이메일을 사용하는 사람이 물건을 구매한적 있는지 확인
    @Query(value = "SELECT * FROM purchase  WHERE email = :email LIMIT 1 ", nativeQuery = true)
    Optional<Purchase> findByEmail(@Param("email") String email);

    //구매 내역중 픽업으로 수령한거
    @Query(value = "SELECT * FROM purchase WHERE email = :email AND delivery = 'PICKUP' ORDER BY purchaseday DESC, ordernumber DESC", nativeQuery = true)
    List<Purchase> Pickuplist(@Param("email") String email);

    //구매 내역중 배달로 수령한거
    @Query(value = "SELECT * FROM purchase WHERE email = :email AND delivery = 'DELIVERY' ORDER BY purchaseday DESC, ordernumber DESC", nativeQuery = true)
    List<Purchase> Deliverylist(@Param("email") String email);

    //구매 내역중 픽업으로 수령한거 최근 5개
    @Query(value = "SELECT * FROM purchase WHERE email = :email AND delivery = 'PICKUP' ORDER BY purchaseday DESC, ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Purchase> Pickuplimt(@Param("email") String email);

    //구매 내역중 배달로 수령한거 최근 5개
    @Query(value = "SELECT * FROM purchase WHERE email = :email AND delivery = 'DELIVERY' ORDER BY purchaseday DESC, ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Purchase> Deliverylimt(@Param("email") String email);

    @Query(value = "SELECT a.* FROM purchase a\n" +
            "LEFT JOIN stock b ON a.stocknumber = b.stocknumber\n" +
            "LEFT JOIN alcohol c ON b.code = c.code\n" +
            "LEFT JOIN review d ON c.code = d.code AND d.email = :email\n" +
            "WHERE a.email = :email AND d.code IS NULL\n", nativeQuery = true)
    List<Purchase> purchasereview(String email);


    @Query(value = "SELECT a.* FROM purchase a\n" +
            "JOIN stock b ON a.stocknumber = b.stocknumber\n" +
            "JOIN alcohol c ON b.code = c.code\n" +
            "WHERE a.email =  :email and c.code = :code",nativeQuery = true)
    Optional<Purchase> reviewPpurchase(String email, Long code);

}