package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.three.alcoholshoppingmall.project.market.Market;
import com.three.alcoholshoppingmall.project.purchase.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailbasketRepository extends JpaRepository<Detailbasket, Long> {
    @Query(value = "SELECT a.* FROM detailbasket a\n" +
            "JOIN shoppingbasket b ON a.shoppingnumber = b.shoppingnumber\n" +
            "WHERE b.email = :email", nativeQuery = true)
    List<Detailbasket> baskets(String email);

    @Query(value = "SELECT a.* from detailbasket a\n" +
            "JOIN shoppingbasket b ON a.shoppingnumber = b.shoppingnumber\n" +
            "JOIN user c ON b.email = c.email\n" +
            "WHERE c.email =  :email\n" +
            "AND a.stocknumber = :stock", nativeQuery = true)
    Optional<Detailbasket> basket(String email, Long stock);

    @Query(value = "SELECT a.name FROM alcohol a\n" +
            "JOIN stock b ON a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email", nativeQuery = true)
    List<String> alcohol(String email);

    @Query(value = "SELECT a.marketname FROM market a\n" +
            "JOIN stock b ON a.marketcode = b.marketcode\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email", nativeQuery = true)
    List<String> market(String email);


    @Query(value = "SELECT a.picture FROM alcohol a\n" +
            "JOIN stock b on  a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email", nativeQuery = true)
    List<String> Picture(String email);

    @Query(value = "SELECT a.amount FROM detailbasket a\n" +
            "JOIN shoppingbasket b ON  a.shoppingnumber = b.shoppingnumber \n" +
            "WHERE b.email = :email AND a.stocknumber = :stocknumber", nativeQuery = true)
    int amount(String email, Long stocknumber);


    @Modifying
    @Query(value = "DELETE FROM detailbasket WHERE shoppingnumber IN (SELECT shoppingnumber FROM shoppingbasket WHERE email = :email)", nativeQuery = true)
    void deldeteall(String email);

    @Query(value = "SELECT COUNT(a.stocknumber) FROM detailbasket a " +
            "JOIN shoppingbasket b ON a.shoppingnumber = b.shoppingnumber " +
            "WHERE b.email = :email", nativeQuery = true)
    Optional<Integer> basketcheck(String email);

    @Query(value = "SELECT b.delivery FROM stock a\n" +
            "JOIN market b ON a.marketcode = b.marketcode\n" +
            "WHERE a.stocknumber = :stock", nativeQuery = true)
    Delivery type(Long stock);


    @Query(value = "SELECT a.* FROM detailbasket a\n" +
            "JOIN shoppingbasket b ON a.shoppingnumber = b.shoppingnumber\n" +
            "WHERE b.email = :email AND a.delivery = 'Delivery'", nativeQuery = true)
    List<Detailbasket> DetailbasketDelivery(String email);

    @Query(value = "SELECT a.name FROM alcohol a\n" +
            "JOIN stock b ON a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'Delivery'", nativeQuery = true)
    List<String> alcoholDelivery(String email);



    @Query(value = "SELECT a.picture FROM alcohol a\n" +
            "JOIN stock b on  a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'Delivery'", nativeQuery = true)
    List<String> PictureDelivery(String email);

    @Query(value = "SELECT a.* FROM detailbasket a\n" +
            "JOIN shoppingbasket b ON a.shoppingnumber = b.shoppingnumber\n" +
            "WHERE b.email = :email AND a.delivery = 'PickUp'", nativeQuery = true)
    List<Detailbasket> DetailbasketPickUp(String email);

    @Query(value = "SELECT a.name FROM alcohol a\n" +
            "JOIN stock b ON a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'PickUp'", nativeQuery = true)
    List<String> alcoholPickUp(String email);



    @Query(value = "SELECT a.picture FROM alcohol a\n" +
            "JOIN stock b on  a.code = b.code\n" +
            "JOIN detailbasket c ON c.stocknumber = b.stocknumber\n" +
            "JOIN shoppingbasket d ON c.shoppingnumber = d.shoppingnumber\n" +
            "WHERE d.email = :email AND c.delivery = 'PickUp'", nativeQuery = true)
    List<String> PicturePickUp(String email);


    @Query(value = "SELECT stocknumber FROM detailbasket WHERE NUMBER =  :id",nativeQuery = true)
    Optional<Long> stocknumber(Long id);


    @Query(value = "SELECT a.stocknumber from stock a\n" +
            "JOIN market b ON a.marketcode = b.marketcode\n" +
            "WHERE a.code = :code AND b.marketname = :marketname",nativeQuery = true)
    Optional<Long> stocknumbers(Long code, String marketname);

    void deleteByNumber(Long number);

    Optional<Detailbasket> findByNumber(Long number);
    
}
