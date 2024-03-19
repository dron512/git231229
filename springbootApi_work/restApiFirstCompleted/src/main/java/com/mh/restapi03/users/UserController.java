package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Tag(name = "User-Controller", description = "유저 조회 등록 수정 삭제")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("usernameemail")
    public ResponseEntity<List<User>> getAllUserName(@RequestBody UserDto userDto){
        List<User> list = userRepository.findByUsernameContainingOrEmailContaining(userDto.getUsername(),userDto.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @Operation(summary = "사용자 전체 목록보기",description = "사용자 전체 정보를 조회 할 수 있습니다.")
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "404", description = "사용자들이 없을때 나옵니다."),
            }
    )
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        if( list.size() ==0 )
            throw new UsersException(ErrorCode.NOTFOUND);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    @Operation(summary = "사용자 한명 보기",description = "사용자 한명의 정보를 조회 할 수 있습니다.")
    @Parameters(
        @Parameter(description = "조회하고자 하는 사용자 ID 입력하세요",
                name = "id",
                required = true)
    )
    public ResponseEntity<User> getUserById(
            @PathVariable Long id){
        System.out.println(id);

        User user = userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping()
    public EntityModel<User> addUser(@RequestBody @Valid UserDto userDto){
        userDto.setWdate(LocalDateTime.now());

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);

        User dbuser = userService.regist( user );

        EntityModel<User> entityModel = EntityModel.of(dbuser);
        entityModel.add(
                WebMvcLinkBuilder.linkTo(UserController.class)
                        .slash(dbuser.getId())
                        .withSelfRel()
        );

        return entityModel;
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto){

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);
        user.setWdate(LocalDateTime.now());

        User dbUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllUser(){
        userService.delete();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @Transactional(readOnly = true)  // 영속성에 의해서 setter 메서드 사용시 db Update 실행됨...
    @GetMapping(value = "users/tran",headers = "version=1")
    public String userstran1(@RequestHeader String aa){
        System.out.println(aa);
        // optional<User> 로 만들어 지기 때문에 orElseThrow 사용..
        User dbUser = userRepository.findById(1L).orElseThrow();
        dbUser.setUsername("김길동");// 업데이트 구문
        dbUser.setEmail("aa@naver.com"); // 업데이트 구문

        return "tran1";
    }

    @Transactional(readOnly = true)  // 영속성에 의해서 setter 메서드 사용시 db Update 실행됨...
    @GetMapping(value = "/tran",headers = "version=2")
    public EntityModel<User> userstran2(@RequestHeader String aa){
        System.out.println(aa);
        // optional<User> 로 만들어 지기 때문에 orElseThrow 사용..
        User dbUser = userRepository.findById(1L).orElseThrow();
        dbUser.setUsername("김길동");// 업데이트 구문
        dbUser.setEmail("aa@naver.com"); // 업데이트 구문

        EntityModel<User> entityModel = EntityModel.of(dbUser);
        entityModel.add(
                WebMvcLinkBuilder.linkTo(UserController.class)
                        .slash("/users")
                        .withSelfRel()
        );

        return entityModel;
    }

}

