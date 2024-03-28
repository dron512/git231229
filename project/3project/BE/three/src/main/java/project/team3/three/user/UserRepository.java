package project.team3.three.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "select m from User m where m.userId = :userId")
    public User findMyCustom(Long userId);



}
