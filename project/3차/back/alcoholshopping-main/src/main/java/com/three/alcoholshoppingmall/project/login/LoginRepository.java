package com.three.alcoholshoppingmall.project.login;

import com.three.alcoholshoppingmall.project.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findByPhone(String phone);
    @Query(value = "select email from user where phone = :phone and birthdate = :birthdate",nativeQuery = true)
    String findByPhoneAndBirthdate(String phone, String birthdate);// 이메일 찾기

}
