package com.mh.fileex.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping(value = "/join", produces = APPLICATION_JSON_VALUE
                                    , consumes =  MULTIPART_FORM_DATA_VALUE)
    public String join(@Valid @RequestPart(value = "userDto") UserDto userDto,
                       @RequestPart(value = "file") MultipartFile imageFile){

        // userDto출력
        System.out.println(userDto);
        // image 파일 이름 출력
        System.out.println(imageFile.getOriginalFilename());

        // UserDto 를 user 로 변환
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        // 변환한 user 출력
        System.out.println(user);
        
        // 파일과 user정보를 가지고 join 함수 호출
        userService.join(user, imageFile);

        return "회원가입";
    }
}
