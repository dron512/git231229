package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "User-Controller", description = "유저 조회 등록 수정 삭제")
public class UserController {

    private final UserService userService;

    @Operation(summary = "사용자 전체 목록보기",description = "사용자 전체 정보를 조회 할 수 있습니다.")
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "ok"),
                    @ApiResponse(responseCode = "404", description = "사용자들이 없을때 나옵니다."),
            }
    )
    @GetMapping("users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userService.getAllUsers();
        if( list.size() ==0 )
            throw new UsersException(ErrorCode.NOTFOUND);
        return ResponseEntity.ok(list);
    }

    @GetMapping("users/{id}")
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

    @PostMapping("users")
    public ResponseEntity<User> addUser(@RequestBody @Valid UserDto userDto){
        userDto.setWdate(LocalDateTime.now());

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);

        User dbuser = userService.regist( user );

        return ResponseEntity.status(HttpStatus.CREATED).body(dbuser);
    }

    @PutMapping("users")
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto){
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);
        user.setWdate(LocalDateTime.now());

        User dbUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

}

