package com.mh.green2nd.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByNickname(String nickname);


    User findByNicknameAndPhone(String nickname, String phone);

//    User findByUser_id(Long userId);


//    User findByUser(Long userId);
}
