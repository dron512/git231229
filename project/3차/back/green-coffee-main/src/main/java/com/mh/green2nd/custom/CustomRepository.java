package com.mh.green2nd.custom;

import com.mh.green2nd.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomRepository extends JpaRepository<Custom, Long> {
    Optional<Custom> findByUser(User customUser);
}
