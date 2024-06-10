package com.pmh.mhconfig.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("add-user")
    public String addUser(@Valid @RequestBody UserDto userDto){
        User user = new ModelMapper().map(userDto,User.class);
        /*
        User user = User.builder()
                        .user_email("bbb@naver.com")
                        .user_password("1234")
                        .user_name("홍길동")
                        .build();
         */
        userRepository.save(user);
        userRepository.save2(user);
        return "inserted";
    }
}
