package com.mh.restapi03.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(), save(), findById()

    // select * from user where email = ?;
    public User findByEmail(String email);

    @Query(value = "select m from User m where m.email = :email")
    public User findMyCustom(String email);
}
