package com.mh.green2nd.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {


    @Query(value = "SELECT * FROM menu WHERE name = :name", nativeQuery = true)
    List<Menu> detail(@Param("name") String name);

    List<Menu> findByNameContaining(String name);

    List<Menu> findByCategory(String Category);

    List<Menu> findByRecommend(Boolean recommend);
}
