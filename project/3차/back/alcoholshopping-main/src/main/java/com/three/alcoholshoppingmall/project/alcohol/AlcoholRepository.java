package com.three.alcoholshoppingmall.project.alcohol;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

    //가장 많이 팔린 술 3개
    @Query(value = "SELECT a.* FROM alcohol a LEFT JOIN ( SELECT s.code\n" +
            "FROM purchase p JOIN stock s ON p.stocknumber = s.stocknumber \n" +
            "WHERE YEARWEEK(p.purchaseday) = YEARWEEK(NOW()) GROUP BY s.code\n" +
            ") AS p ON a.code = p.code GROUP BY a.code, a.price \n" +
            "ORDER BY COUNT(p.code) DESC, a.code ASC \n" +
            "LIMIT 3", nativeQuery = true)
    List<Alcohol> mostsold();


    //가장 많이 팔린술의 평점
    @Query(value = "SELECT ROUND(COALESCE(AVG(r.grade), 0), 1) AS average_grade\n" +
            "FROM alcohol a LEFT JOIN ( SELECT s.code, COUNT(p.ordernumber) AS total_orders\n" +
            "FROM purchase p JOIN stock s ON p.stocknumber = s.stocknumber \n" +
            "WHERE YEARWEEK(p.purchaseday) = YEARWEEK(NOW()) GROUP BY s.code\n" +
            ") AS p ON a.code = p.code LEFT JOIN review r ON a.code = r.code\n" +
            "GROUP BY a.code ORDER BY COALESCE(MAX(p.total_orders), 0) DESC, a.code ASC\n" +
            "LIMIT 3", nativeQuery = true)
    List<Double> mostsoldgrade();

    //랜덤
    @Query(value = "SELECT * FROM alcohol ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Alcohol> RAND();

    @Query(value = "SELECT ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade\n" +
            "FROM alcohol a\n" +
            "LEFT JOIN review b ON a.code = b.code\n" +
            "WHERE a.code = :code\n" +
            "GROUP BY a.code\n" +
            "LIMIT 3 ", nativeQuery = true)
    List<Double> Randgrade(Long code);

    //신제품
    @Query(value = "SELECT * FROM alcohol ORDER BY code DESC LIMIT 3", nativeQuery = true)
    List<Alcohol> newproduct();

    @Query(value = "SELECT ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade\n" +
            "FROM alcohol a LEFT JOIN review b ON a.code = b.code\n" +
            "GROUP BY a.code ORDER BY a.code DESC\n" +
            "LIMIT 3", nativeQuery = true)
    List<Double> newgrade();


    List<Alcohol> findBySubcategoryOrMaincategory(String subcategory, String maincategory); // 카테고리(소분류나 대분류)로 주류 검색하기

    List<Alcohol> findByNameContaining(String name);// 이름으로 주류 검색하기

    Optional<Alcohol> findByCode(Long code);

    //특정 술의 평점
    @Query(value = "SELECT ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade \n" +
            "FROM alcohol a LEFT JOIN review b ON a.code = b.code \n" +
            "WHERE a.code = :code GROUP BY a.name\n", nativeQuery = true)
    Double Rating(Long code);

    @Query(value = "SELECT\n" +
            "        ROUND(COALESCE(AVG(b.grade), 0), 1) AS average_grade \n" +
            "\t\t  ,a.name,a.price,a.code\n" +
            "    FROM\n" +
            "        alcohol a \n" +
            "    LEFT OUTER JOIN\n" +
            "        review b \n" +
            "            ON a.code = b.code  \n" +
            "    GROUP BY\n" +
            "       a.name,a.price,a.code\n" +
            "\tHAVING a.name LIKE :name", nativeQuery = true)
    List<Double> RatingList(String name);

    //특정 술의 가격
    @Query("SELECT a.price FROM Alcohol a WHERE a.code= :code")
    int Price(Long code);


    // 인기순
    @Query(value = "SELECT a.*  FROM alcohol a \n" +
            "LEFT JOIN (SELECT s.code, COUNT(p.ordernumber) AS total_amount \n" +
            "FROM purchase p JOIN stock s ON s.stocknumber = p.stocknumber \n" +
            "GROUP BY s.code) AS p ON a.code = p.code\n" +
            "WHERE a.maincategory = :maincategory\n" +
            "ORDER BY COALESCE(total_amount, 0) DESC, a.code ASC", nativeQuery = true)
    List<Alcohol> popmain(String maincategory);

    // 인기순 평점
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS avg_rating FROM alcohol a\n" +
            "LEFT JOIN review r ON a.code = r.code\n" +
            "LEFT JOIN ( SELECT s.code, SUM(p.amount) AS total_amount\n" +
            "FROM purchase p JOIN stock s ON s.stocknumber = p.stocknumber\n" +
            "GROUP BY s.code ) AS p ON a.code = p.code\n" +
            "WHERE a.maincategory = :maincategory\n" +
            "GROUP BY a.code\n" +
            "ORDER BY COALESCE(SUM(p.total_amount), 0) DESC, a.code ASC", nativeQuery = true)
    List<Double> popratingsmain(String maincategory);

    // 최대 가격 순 정렬
    @Query(value = "SELECT * FROM alcohol where maincategory = :maincategory ORDER BY price DESC, code ASC", nativeQuery = true)
    List<Alcohol> maxmain(String maincategory);

    // 최대 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.code = r.code\n" +
            "WHERE a.maincategory = :maincategory\n" +
            "GROUP BY a.code, a.name ORDER BY COALESCE(MAX(a.price), 0) DESC, a.code ASC", nativeQuery = true)
    List<Double> maxratingsmain(String maincategory);


    // 최소 가격 순 정렬
    @Query(value = "SELECT * FROM alcohol where maincategory = :maincategory ORDER BY price ASC, code ASC", nativeQuery = true)
    List<Alcohol> minmain(String maincategory);

    // 최소 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.code = r.code\n" +
            "WHERE a.maincategory = :maincategory\n" +
            "GROUP BY a.code, a.name ORDER BY COALESCE(MAX(a.price), 0) ASC, a.code ASC", nativeQuery = true)
    List<Double> minratingsmain(String maincategory);

    // 인기순
    @Query(value = "SELECT a.*  FROM alcohol a \n" +
            "LEFT JOIN (SELECT s.code, COUNT(p.ordernumber) AS total_amount \n" +
            "FROM purchase p JOIN stock s ON s.stocknumber = p.stocknumber \n" +
            "GROUP BY s.code) AS p ON a.code = p.code\n" +
            "WHERE a.subcategory = :subcategory\n" +
            "ORDER BY COALESCE(total_amount, 0) DESC, a.code ASC", nativeQuery = true)
    List<Alcohol> popsub(String subcategory);

    // 인기순 평점
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS avg_rating FROM alcohol a\n" +
            "LEFT JOIN review r ON a.code = r.code\n" +
            "LEFT JOIN ( SELECT s.code, SUM(p.amount) AS total_amount\n" +
            "FROM purchase p JOIN stock s ON s.stocknumber = p.stocknumber\n" +
            "GROUP BY s.code ) AS p ON a.code = p.code\n" +
            "WHERE a.subcategory = :subcategory\n" +
            "GROUP BY a.code\n" +
            "ORDER BY COALESCE(SUM(p.total_amount), 0) DESC, a.code ASC", nativeQuery = true)
    List<Double> popratingssub(String subcategory);

    // 최대 가격 순 정렬
    @Query(value = "SELECT * FROM alcohol where subcategory = :subcategory ORDER BY price DESC, code ASC", nativeQuery = true)
    List<Alcohol> maxsub(String subcategory);

    // 최대 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.code = r.code\n" +
            "WHERE a.subcategory = :subcategory\n" +
            "GROUP BY a.code, a.name ORDER BY COALESCE(MAX(a.price), 0) DESC, a.code ASC", nativeQuery = true)
    List<Double> maxratingssub(String subcategory);


    // 최소 가격 순 정렬
    @Query(value = "SELECT * FROM alcohol where subcategory = :subcategory ORDER BY price ASC, code ASC", nativeQuery = true)
    List<Alcohol> minsub(String subcategory);

    // 최소 가격 순 정렬시 평점 정렬
    @Query(value = "SELECT COALESCE(AVG(r.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a LEFT JOIN review r ON a.code = r.code\n" +
            "WHERE a.subcategory = :subcategory\n" +
            "GROUP BY a.code, a.name ORDER BY COALESCE(MAX(a.price), 0) ASC, a.code ASC", nativeQuery = true)
    List<Double> minratingssub(String subcategory);


    @Query(value = "SELECT name from alcohol where code = :code", nativeQuery = true)
    String name(Long code);

    @Query(value = "SELECT a.name FROM alcohol a JOIN favorites b ON a.code = b.code WHERE b.email = :email", nativeQuery = true)
    List<String> MyFavoritesname(String email);

    @Query(value = "SELECT a.code FROM alcohol a JOIN favorites b ON a.code = b.code WHERE b.email = :email", nativeQuery = true)
    List<Long> MyFavoritescode(String email);

    @Query(value = "SELECT a.picture FROM alcohol a JOIN favorites b ON a.code = b.code WHERE b.email = :email", nativeQuery = true)
    List<String> MyFavoritespicture(String email);


    @Query(value = "SELECT a.*\n" +
            "FROM alcohol a\n" +
            "LEFT JOIN stock b ON a.code = b.code\n" +
            "LEFT JOIN market c ON c.marketcode = b.marketcode\n" +
            "WHERE c.delivery = :type\n" +
            "GROUP BY a.code ORDER BY a.code", nativeQuery = true)
    List<Alcohol> Markettype(String type);


    @Query(value = "SELECT COALESCE(AVG(b.grade), 0) AS ratingaverage\n" +
            "FROM alcohol a \n" +
            "LEFT JOIN review b ON a.code = b.code \n" +
            "LEFT JOIN stock c ON a.code = c.code \n" +
            "LEFT JOIN market d ON c.marketcode = d.marketcode\n" +
            "WHERE d.delivery = :type\n" +
            "GROUP BY a.code ORDER BY a.code", nativeQuery = true)
    List<Double> Markeratingaverage(String type);


    @Query(value = "SELECT c.* FROM purchase a " +
            "LEFT JOIN stock b ON a.stocknumber = b.stocknumber " +
            "LEFT JOIN alcohol c ON b.code = c.code " +
            "LEFT JOIN review d ON c.code = d.code AND d.email = :email " +
            "LEFT JOIN market e ON b.marketcode = e.marketcode " +
            "WHERE a.email = :email AND d.code IS NULL", nativeQuery = true)
    List<Alcohol> alcoholreview(String email);

    @Query(value = "SELECT code FROM alcohol  WHERE  NAME = :alcoholName",nativeQuery = true)
    Long code(String alcoholName);

    @Query(value = "SELECT a.*\n" +
            "FROM alcohol a \n" +
            "JOIN stock b ON a.code = b.code \n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email\n" +
            "AND c.delivery = 'PICKUP' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC", nativeQuery = true)
    List<Alcohol> alcoholspick(String email);

    @Query(value = "SELECT a.* \n" +
            "FROM alcohol a \n" +
            "JOIN stock b ON a.code = b.code \n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email\n" +
            "AND c.delivery = 'DELIVERY' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC", nativeQuery = true)
    List<Alcohol> alcoholsdelivery(String email);

    @Query(value = "SELECT a.*\n" +
            "FROM alcohol a \n" +
            "JOIN stock b ON a.code = b.code \n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email\n" +
            "AND c.delivery = 'PICKUP' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Alcohol> alcoholspicklimt(String email);

    @Query(value = "SELECT a.* \n" +
            "FROM alcohol a \n" +
            "JOIN stock b ON a.code = b.code \n" +
            "JOIN purchase c ON b.stocknumber = c.stocknumber \n" +
            "WHERE c.email = :email\n" +
            "AND c.delivery = 'DELIVERY' \n" +
            "ORDER BY c.purchaseday DESC, c.ordernumber DESC LIMIT 5", nativeQuery = true)
    List<Alcohol> alcoholsdeliverylimt(String email);
}

