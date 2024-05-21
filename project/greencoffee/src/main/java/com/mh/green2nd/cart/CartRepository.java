package com.mh.green2nd.cart;

import com.mh.green2nd.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {


//    List<Cart> findByUser(User user);
//    void deleteByIdAndUser(Long cartId, User user);
//    select * from cart where user_id = ? and cart_id = ?
//    void deleteByUserIdAndId(Long userId, User user);

    void deleteByCartId(Long cartId);

    Optional<Cart> findByUser(User user);

//    Optional<Cart> findByUser_user_id(Long userId);
}
