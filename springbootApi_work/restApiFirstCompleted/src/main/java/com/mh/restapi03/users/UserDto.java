package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDto {

    private Long id;

    @NotBlank
//    @Pattern (regexp = "^[a-zA-Z0-0]*$", message = "사용자이름은 영어랑 숫자만 가능합니다.")
    private String username;

    @Size(min=5, max = 50)
    private String email;

    private String password;

    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

    public static User of(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setWdate(LocalDateTime.now());
        return user;
    }
}
