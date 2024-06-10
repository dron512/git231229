package com.three.alcoholshoppingmall.project.market;

import com.three.alcoholshoppingmall.project.purchase.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {


    @Query(value = "SELECT a.* FROM market a \n" +
            "LEFT JOIN stock b ON a.marketcode = b.marketcode \n" +
            "LEFT JOIN alcohol c ON b.code = c.code \n" +
            "WHERE c.code = :code", nativeQuery = true)
    List<Market> marketlist(Long code);


    @Query(value = "SELECT e.* FROM purchase a " +
            "LEFT JOIN stock b ON a.stocknumber = b.stocknumber " +
            "LEFT JOIN alcohol c ON b.code = c.code " +
            "LEFT JOIN review d ON c.code = d.code AND d.email = :email " +
            "LEFT JOIN market e ON b.marketcode = e.marketcode " +
            "WHERE a.email = :email and d.code IS NULL", nativeQuery = true)
    List<Market> marketreview(String email);

    @Query(value = "SELECT a.*\n" +
            "FROM market a \n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email\n" +
            "AND c.delivery = 'PICKUP' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC", nativeQuery = true)
    List<Market> marketspick(String email);


    @Query(value = "SELECT a.*\n" +
            "FROM market a \n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email \n" +
            "AND c.delivery = 'DELIVERY' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC", nativeQuery = true)
    List<Market> marketsdelivery(String email);

    @Query(value = "SELECT a.*\n" +
            "FROM market a \n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email \n" +
            "AND c.delivery = 'PICKUP' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Market> marketspicklimt(String email);

    @Query(value = "SELECT a.*\n" +
            "FROM market a \n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email \n" +
            "AND c.delivery = 'DELIVERY' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Market> marketsdeliverylimt(String email);


    @Query(value = "SELECT a.* FROM market a\n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'Delivery'", nativeQuery = true)
    List<Market> marketDelivery(String email);



    @Query(value = "SELECT a.* FROM market a\n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'PickUp'", nativeQuery = true)
    List<Market> marketPickUp(String email);
}
