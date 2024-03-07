package org.example.studyspringbootsecurity.controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

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
}
