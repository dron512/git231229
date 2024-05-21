package com.mh.green2nd.item;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("item")
@SecurityRequirement(name = "Bearer Authentication")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("test")
    public String test(Authentication authentication){
        System.out.println(authentication);
        User loginUser = (User) authentication;
        System.out.println(loginUser);
        return "test";
    }
}
