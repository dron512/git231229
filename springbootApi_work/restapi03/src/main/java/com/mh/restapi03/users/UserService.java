package com.mh.restapi03.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){

        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser != null){
            System.out.println(user.getEmail()+"중복 이메일이 있습니다.");
            throw new RuntimeException("중복이메일");
        }

        // insert 구문 실행...
        User dbUser = userRepository.save(user);
        return dbUser;
    }

    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
