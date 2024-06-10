package com.three.alcoholshoppingmall.project.review;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    //해당 술의 리뷰 갯수
    @Query(value = "SELECT COUNT(*) FROM review a \n" +
            "LEFT JOIN alcohol b ON a.code = b.code \n" +
            "WHERE b.code = :code", nativeQuery = true)
    int Reviewcacount(Long code);

    @Query(value = "SELECT a.name FROM alcohol a JOIN review b ON a.code = b.code WHERE b.email = :email ORDER BY b.ID DESC", nativeQuery = true)
    List<String> names(String email);

    @Query(value = "SELECT * FROM review where email = :email ORDER BY ID DESC",nativeQuery = true)
    List<Review> reviews(String email);
    Optional<Review> findByUser_EmailAndAlcohol_Code(String email, Long code);

    void deleteByUser_EmailAndId(String email, Long id);

    List<Review>findByAlcohol_Code(Long code);

    Optional<Review>findByUser_EmailAndId(String email, Long id);



}
