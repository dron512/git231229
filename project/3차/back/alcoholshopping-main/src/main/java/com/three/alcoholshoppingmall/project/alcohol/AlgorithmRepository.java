package com.three.alcoholshoppingmall.project.alcohol;


import com.three.alcoholshoppingmall.project.alcohol.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlgorithmRepository extends JpaRepository<Alcohol, Long> {

    // 가장 많이 구매된 주류의 향
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX" +
            "(SUBSTRING_INDEX(a.aroma, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '') AS word FROM alcohol a  \n" +
            "INNER JOIN purchase p ON a.code = p.ordernumber JOIN (SELECT 1 + units.i + tens.i * 10 AS n \n" +
            "FROM (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units CROSS JOIN \n" +
            "(SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens\n" +
            ") AS numbers ON CHAR_LENGTH(a.aroma) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 WHERE p.email = :email\n" +
            "GROUP BY REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.aroma, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '')\n" +
            "ORDER BY SUM(p.amount) DESC LIMIT 1", nativeQuery = true)
    String Aroma(String email);
    // 가장 많이 구매된 주류의 맛
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX" +
            "(SUBSTRING_INDEX(a.taste, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '') AS word FROM alcohol a  \n" +
            "INNER JOIN purchase p ON a.code = p.ordernumber JOIN (SELECT 1 + units.i + tens.i * 10 AS n \n" +
            "FROM (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units CROSS JOIN \n" +
            "(SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens\n" +
            ") AS numbers ON CHAR_LENGTH(a.taste) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 WHERE p.email = :email\n" +
            "GROUP BY REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.taste, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '')\n" +
            "ORDER BY SUM(p.amount) DESC LIMIT 1", nativeQuery = true)
    String Taste(String email);
    // 가장 많이 구매된 주류의 여운
    @Query(value = "SELECT REPLACE(REPLACE(SUBSTRING_INDEX" +
            "(SUBSTRING_INDEX(a.finish, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '') AS word FROM alcohol a  \n" +
            "INNER JOIN purchase p ON a.code = p.ordernumber JOIN (SELECT 1 + units.i + tens.i * 10 AS n \n" +
            "FROM (SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS units CROSS JOIN \n" +
            "(SELECT 0 AS i UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT " +
            "4 UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 UNION SELECT 9) AS tens\n" +
            ") AS numbers ON CHAR_LENGTH(a.finish) - CHAR_LENGTH(REPLACE(a.finish, ',', '')) >= numbers.n - 1 WHERE p.email = :email\n" +
            "GROUP BY REPLACE(REPLACE(SUBSTRING_INDEX(SUBSTRING_INDEX(a.finish, ',', numbers.n), ',', -1), '\\\\\\\"', ''), ' ', '')\n" +
            "ORDER BY SUM(p.amount) DESC LIMIT 1", nativeQuery = true)
    String Finish(String email);
    //데이터 취합 후 추천
    @Query(value = "SELECT DISTINCT * FROM alcohol " +
            "WHERE (aroma LIKE CONCAT('%', :aroma, '%') OR taste LIKE CONCAT('%', :taste, '%') OR finish LIKE CONCAT('%', :finish, '%')) " +
            "ORDER BY RAND() LIMIT 3", nativeQuery = true)
   List<Alcohol> personalalgorithm( String aroma, String taste, String finish);
}
