package project.team3.three.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.team3.three.user.User;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    // insert 쿼리문으로 적기(탈퇴여부 N)


    // 이메일, 전화번호 중복체크
    public User findByEmailAndPhoneNum(String email, String phoneNum);
    
    // 로그인
    @Query(value = "SELECT *" +
                    " FROM user u" +
                   " WHERE 1 = 1" +
                     " AND u.email = :email" +
                     " AND u.password = :password" +
                     " AND u.withdraw_status = 'N'" , nativeQuery = true)
    public User findByEmailAndPasswordAndN(String email, String password);

    // 아이디(이메일) 찾기
    @Query(value = "SELECT u.email" +
                    " FROM user u" +
                   " WHERE 1 = 1" +
                     " AND u.name = :name" +
                     " AND u.studies = :studies" +
                     " AND u.phone_num = :phoneNum" , nativeQuery = true)
    public Optional<String> findByNameAndStudiesAndPhoneNum(String name, String studies, String phoneNum);


    // 비밀번호 찾기
    @Query(value = "SELECT u.password" +
                    " FROM user u" +
                   " WHERE 1 = 1" +
                     " AND u.name = :name" +
                     " AND u.studies = :studies" +
                     " AND u.phone_num = :phoneNum" +
                     " AND u.email = :email" , nativeQuery = true)
    public Optional<Long> findByNameAndStudiesAndPhoneNumAndEmail(String name, String studies, String phoneNum, String email);
}
