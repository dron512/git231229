package com.mh.green2nd.user;

import com.mh.green2nd.jwt.TokenManager;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "UserController입니다?", description = "유저관련모든기능?")
public class UserController {

    private final UserService userService;
    private final TokenManager tokenManager;

    @Operation(summary = "회원가입",description = "회원가입할 때 입력값은 email, password, nickname, phone, birthdate")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "회원가입 완료 되었을 때 나오는코드"),
            @ApiResponse(responseCode = "400",description = "회원가입 실패했을 때 나오는코드"),
    })

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody UserDto userDto){

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);

        User signupUser = userService.signup(user);
        return ResponseEntity.status(HttpStatus.OK).body(signupUser);
    }

    @Operation(summary = "로그인 입력값 = email and password")
     @ApiResponses({
            @ApiResponse(responseCode = "201",description = "로그인 정보가 있으면 나오는거임"),
            @ApiResponse(responseCode = "500",description = "이미 탈퇴한 계정이거나 정보가 틀렸을 때")
    })
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
        User loginUser = userService.login(loginDto.getEmail(), loginDto.getPassword());
        String token = tokenManager.generateToken(loginUser);
        loginUser.setToken(token);
    return ResponseEntity.status(HttpStatus.CREATED).body(loginUser);
    }

    @Operation(summary = "이메일 찾기 입력값 \"nickname\": \"고죠사토루\",\n" +
            "  \"phone\": \"01011111111\"")
    @ApiResponses({
            @ApiResponse(responseCode = "201",description = "로그인 정보가 있으면 나오는거임"),
            @ApiResponse(responseCode = "500",description = "그런 유저가 없을 때")
    })
    @PostMapping("/findemail")
    public ResponseEntity<String> Findemail(@RequestBody User user){
        String email = userService.findemail(user.getNickname(),user.getPhone());

        return ResponseEntity.status(HttpStatus.OK).body(email);
    }

    @Operation(summary = "비밀번호 찾기 입력값 \"nickname\": \"고죠사토루\",\n" +
            "  \"phone\": \"01011111111\"")
    @ApiResponses({
            @ApiResponse(responseCode = "201",description = "로그인 정보가 있으면 나오는거임"),
            @ApiResponse(responseCode = "500",description = "그런 유저가 없을 때")
    })
    @PostMapping("/findpw")
    public ResponseEntity<String> findfw(FindPwDto findPwDto){
        String password = userService.findpw(findPwDto.getNickname(),findPwDto.getPhone());

        return ResponseEntity.status(HttpStatus.OK).body(password);
    }


    @Operation(summary = "회원정보수정 이메일은 수정불가 이메일에는 수정할 로그인한 수정될 이메일 적어야함 그리고 수정할 값은 적고 아닌 값은 지우면 됨"
            ,description = "수정할 때 해당 이메일이 무조건 들어가야함, 뭘 바꾸는지 조건이 이메일이기 때문에 그리고 수정할 때도 정규식 조건에 맞아야 하는데 스웨거에서는 리퀘스트바디에 String이나 null이 아니라 지멋대로 조건에 맞는 예시가 들어가 있음")
    @ApiResponses({
            @ApiResponse(responseCode = "202",description = "정상 변경 되었을 때 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "정규식의 조건에 맞지 않을 때 나오는 코드"),
            @ApiResponse(responseCode = "400",description = "필수 입력 사항이 없을 때")
    })
    @PutMapping("/update")
    public ResponseEntity<User> update(@Valid @RequestBody UpdateDto updateDto) {
        System.out.println("여기오나 컨트롤러까지?");
        User updatedUser = userService.updateUserByEmail(updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
    }

    @Operation(summary = "회원탈퇴 입력값 \"email\": \"aaa@naver.com\"",description = "회원정보 삭제하지 않고 탈퇴여부만 N에서 Y로 변경")
    @ApiResponses({
            @ApiResponse(responseCode = "202",description = "회원탈퇴완료 되었을 때 나오는코드"),
            @ApiResponse(responseCode = "500",description = "이메일 못찾은경우")
    })
    @PutMapping("/resign")
    public ResponseEntity<String> resgin(@RequestBody User user){
        String result = userService.resignuser(user.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    // 비밀번호체크 api
    @Operation(summary = "비밀번호체크 입력값 email, password",description = "비밀번호가 맞는지 확인할 때 사용하는 api")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "비밀번호가 맞을 때 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "비밀번호가 틀렸을 때 나오는 코드")
    })
    @PostMapping("/checkpw")
    public ResponseEntity<String> checkpw(@RequestBody PwCheckDto pwCheckDto, Authentication authentication){
        System.out.println(authentication);
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        String result = userService.checkpw(user.getEmail(),pwCheckDto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //logout api
    @Operation(summary = "로그아웃",description = "로그아웃할 때는 토큰을 가지고 있어야함")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "로그아웃 성공시 나오는 코드"),
            @ApiResponse(responseCode = "500",description = "로그아웃 실패시 나오는 코드")
    })
    @PostMapping("/logout")
    public ResponseEntity<String> logout(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body("ᕦʕ •ᴥ•ʔᕤ 로그아웃 성공 ᕦʕ •ᴥ•ʔᕤ");
    }

}
