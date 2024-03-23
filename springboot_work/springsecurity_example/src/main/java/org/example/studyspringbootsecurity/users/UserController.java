package org.example.studyspringbootsecurity.users;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("user")
    public ResponseEntity<Users> user(){
        return ResponseEntity.ok(new Users("김길동","bbb@naver.com"));
    }

    @GetMapping("users")
    public EntityModel<Users> users(){
        EntityModel<Users> entityModel = EntityModel.of(new Users("홍길동","aaa@naver.com"));
        entityModel.add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).user())
                        .slash("/user")
                        .slash("1")
                        .withSelfRel()
        );
        return entityModel;
    }

    @PostMapping("users")
    public EntityModel<Users> users(@RequestBody Users users, @RequestHeader String id){
        System.out.println(id);
        System.out.println(users);
        Users dbUsers = userService.save(users);
        EntityModel<Users> entityModel = EntityModel.of(dbUsers);
        entityModel.add(
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).user())
                        .slash("/user")
                        .slash("1")
                        .withSelfRel()
        );
        return entityModel;
    }
}
