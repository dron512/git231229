package com.mh.restapi03.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User regist(User user){
        // insert 구문 실행...
        User dbUser = userRepository.save(user);
        return dbUser;
    }
}
