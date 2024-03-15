package com.mh.restapi03.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // findAll(), save(), findById()

    // select * from user where email = ?;
    public User findByEmail(String email);

    // select * from user where email =? and password =?;
    public User findByEmailAndPassword(String email,String password);


    // pagging
    // select * from user where username like '%길동%' or email like '%aaa% limit 0,5'
    public List<User> findByUsernameContainingOrEmailContaining(String username,String email);


    // JPQL Queydsl
    @Query(value = "select m from User m where m.email = :email")
    public User findMyCustom(String email);
}
