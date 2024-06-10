package com.three.alcoholshoppingmall.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByPhone(String phone);


    Optional<User> findByEmailAndTempPw(String email,String tempPw);

    @Query(value = "SELECT b.* FROM review a\n" +
            "join user b ON a.email = b.email\n" +
            "WHERE a.code = :code",nativeQuery = true)
    List<User> reviewnickname(Long code);


}