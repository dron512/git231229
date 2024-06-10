package com.mh.green2nd.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);
    User findByEmail(String email);

    User findByNickname(String nickname);
    User findByPhone(String phone);

    User findByNicknameAndPhone(String nickname, String phone);

    List<User> findAllByResignAndResignDateBefore(Resign resign, LocalDateTime oneMonthAgo);

//    List<User> findAllByResignAndResignDateBefore(Resign resign, LocalDateTime dateTime);

//    User findByUser_id(Long userId);

    Optional<User> findById(Long userId);

    User findByRefreshToken(String refreshToken);


}
