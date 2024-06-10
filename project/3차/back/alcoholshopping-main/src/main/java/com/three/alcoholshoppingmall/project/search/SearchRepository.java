package com.three.alcoholshoppingmall.project.search;

import com.three.alcoholshoppingmall.project.user.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
    @Query(value = "  SELECT DISTINCT searchcontents\n" +
            "FROM search\n" +
            "WHERE email = :email \n" +
            "ORDER BY searchcontents DESC \n" +
            "LIMIT 5; ",nativeQuery = true)
    List<String> findAllByUserOrderByIdDesc(String email);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO search (email, searchcontents) VALUES (:email, :searchcontents)", nativeQuery = true)
    void searchsave(String email, String searchcontents);

}