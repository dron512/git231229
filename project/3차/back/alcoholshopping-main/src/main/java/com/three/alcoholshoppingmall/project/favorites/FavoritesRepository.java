package com.three.alcoholshoppingmall.project.favorites;

import com.three.alcoholshoppingmall.project.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {


    //해당 회원의 즐겨찾기
    Optional<Favorites> findByUser_EmailAndAlcohol_Code(String email, Long code);

    List<Favorites> deleteByUser_EmailAndAlcohol_Code(String email, Long code);

    @Query(value = "select * from favorites where code = :code and email = :email",nativeQuery = true)
    Favorites selectFavoriteCode(Long code, String email);
}
