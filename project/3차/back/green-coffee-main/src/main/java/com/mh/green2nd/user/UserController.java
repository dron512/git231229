package com.mh.green2nd.user;

import com.mh.green2nd.exception.ErrorCode;
import com.mh.green2nd.exception.UserException;
import com.mh.green2nd.jwt.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.io.UnsupportedEncodingException;


@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "UserController입니다?", description = "유저관련모든기능?")
public class UserController {

    private final UserService userService;
    private final TokenManager tokenManager;
    private final EmailService emailService;
    private final UserRepository userRepository;


    @Operation(summary = "회원가입", description = "회원가입할 때 입력값은 email, password, nickname, phone, birthdate")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원가입 완료 되었을 때 나오는코드"),
            @ApiResponse(responseCode = "400", description = "회원가입 실패했을 때 나오는코드"),
    })

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@Valid @RequestBody UserDto userDto) {

//        String verificationCode = userService.sendVerificationEmail(userDto.getEmail());
//        userDto.setVerificationCode(verificationCode);

        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);

        User signupUser = userService.signup(user);
        return ResponseEntity.status(HttpStatus.OK).body(signupUser);
    }


    @Operation(summary = "로그인 입력값 = email and password", description = "eee@naver.com : superadmin, ddd@naver.com : admin)")
    @ApiResponses({

            @ApiResponse(responseCode = "201", description = "로그인 성공한 경우"),
            @ApiResponse(responseCode = "400", description = "탈퇴한 계정이거나 정보가 틀렸을 때")
    })
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
//        User loginUser = userService.login(loginDto.getEmail(), loginDto.getPassword());
//        String token = tokenManager.generateToken(loginUser);
//        loginUser.setToken(token);
//        return ResponseEntity.status(HttpStatus.CREATED).body(loginUser);

        User loginUser = userService.login(loginDto.getEmail(), loginDto.getPassword());
        String token = tokenManager.generateToken(loginUser);
        String refreshToken = tokenManager.generateRefreshToken(loginUser.getUser_id());
        userService.saveRefreshToken(loginUser.getUser_id(), refreshToken);
        loginUser.setToken(token);
        loginUser.setRefreshToken(refreshToken);
        return ResponseEntity.status(HttpStatus.CREATED).body(loginUser);
    }

    // 리프레시 토큰으로 액세스 토큰 재발급
//    @PostMapping("/newToken")
//    public ResponseEntity<String> token(@RequestBody String refreshToken) {
//        Jws<Claims> claims = tokenManager.validateToken(refreshToken);
//        Long userId = Long.parseLong(claims.getBody().getId());
//
//        if (userService.validateRefreshToken(userId, refreshToken)) {
//            User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//            String newAccessToken = tokenManager.generateToken(user);
//            return ResponseEntity.ok(newAccessToken);
//        } else {
//            throw new RuntimeException("Invalid refresh token");
//        }
//    }

    @Operation(summary = "리프레시 토큰으로 액세스 토큰 재발급", description = "설명")
    @ApiResponses({

            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "실패")
    })
    @PostMapping("/refresh")
    public ResponseEntity<String> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        String newAccessToken = userService.validateAndRefresh(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.ok(newAccessToken);
    }


    @Operation(summary = "이메일 찾기 입력값 = 폰번호")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공하면"),
            @ApiResponse(responseCode = "400", description = "그런 유저가 없을 때")
    })
    @PostMapping("/findemail")
    public ResponseEntity<String> Findemail(@RequestBody FindPwDto findPwDto) {
        String email = userService.findemail(findPwDto.getPhone());

        return ResponseEntity.status(HttpStatus.OK).body(email);
    }

    @Operation(summary = "비밀번호찾기 입력값 = 폰번호")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "성공하면"),
            @ApiResponse(responseCode = "400", description = "그런 유저가 없을 때")
    })
    @PostMapping("/findpw")
    public ResponseEntity<String> findfw(@RequestBody FindPwDto findPwDto) {
        String password = userService.findpw(findPwDto.getPhone());

        return ResponseEntity.status(HttpStatus.OK).body(password);
    }


    @Operation(summary = "회원정보수정 이메일은 수정불가 이메일에는 수정할 로그인한 수정될 이메일 적어야함 그리고 수정할 값은 적고 아닌 값은 지우면 됨"
            , description = "수정할 때 해당 이메일이 무조건 들어가야함, 뭘 바꾸는지 조건이 이메일이기 때문에 그리고 수정할 때도 정규식 조건에 맞아야 하는데 스웨거에서는 리퀘스트바디에 String이나 null이 아니라 지멋대로 조건에 맞는 예시가 들어가 있음")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "정상 변경 되었을 때 나오는 코드"),
            @ApiResponse(responseCode = "400", description = "정규식의 조건에 맞지 않을 때 나오는 코드"),
            @ApiResponse(responseCode = "400", description = "필수 입력 사항이 없을 때")
    })
    @PutMapping("/update")
    public ResponseEntity<User> update(@Valid @RequestBody UpdateDto updateDto) {
        System.out.println("여기오나 컨트롤러까지?");
        User updatedUser = userService.updateUserByEmail(updateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
    }

    @Operation(summary = "회원탈퇴 입력값 \"email\": \"aaa@naver.com\"", description = "회원정보 삭제하지 않고 탈퇴여부만 N에서 Y로 변경")
    @ApiResponses({
            @ApiResponse(responseCode = "202", description = "회원탈퇴완료 되었을 때 나오는코드"),
            @ApiResponse(responseCode = "400", description = "이메일 못찾은경우")
    })
    @PutMapping("/resign")
    public ResponseEntity<String> resgin(@RequestBody User user) {
        String result = userService.resignuser(user.getEmail());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }
//    @PutMapping("/resign")
//    public ResponseEntity<String> resgin(Authentication authentication){
//        String result = userService.resignuser(user.getEmail());
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
//    }


    // 비밀번호체크 api
    @Operation(summary = "비밀번호체크 입력값 password", description = "비밀번호가 맞는지 확인할 때 사용하는 api")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "비밀번호가 맞을 때 나오는 코드"),
            @ApiResponse(responseCode = "400", description = "비밀번호가 틀렸을 때 나오는 코드")
    })
    @PostMapping("/checkpw")
    public ResponseEntity<String> checkpw(@RequestBody PwCheckDto pwCheckDto, Authentication authentication) {
        System.out.println(authentication);
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        String result = userService.checkpw(user.getEmail(), pwCheckDto.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    //logout api
    @Operation(summary = "로그아웃", description = "로그아웃할 때는 토큰을 가지고 있어야함")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "로그아웃 성공시 나오는 코드"),
            @ApiResponse(responseCode = "400", description = "로그아웃 실패시 나오는 코드")
    })
    @PostMapping("/logout")
    public ResponseEntity<String> logout(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        System.out.println(user);
        return ResponseEntity.status(HttpStatus.OK).body("ᕦʕ •ᴥ•ʔᕤ 로그아웃 성공 ᕦʕ •ᴥ•ʔᕤ");
    }

    //------------------------------------------------------------------------------------------------
    @ResponseBody
    @Operation(summary = "이메일 인증코드 전송", description = "이메일 인증코드 전송")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상적으로 보냈을 때"),
            @ApiResponse(responseCode = "500", description = "메일 보내기 실패했을 경우")
    })
    @PostMapping("/code")
    public ResponseEntity<String> EmailCheck(String email, HttpServletResponse response) {
        System.out.println(email);
        try {
            String authCode = emailService.sendEmail(email, response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("인증번호 전송 실패");
        }
        return ResponseEntity.status(200).body("저장");    // Response body에 값을 반환해줄게요~
    }
//-----------------------------------------------------------------------------------------------

    @Operation(summary = "이메일 인증코드 확인", description = "이메일 인증코드 확인")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "인증 코드가 일치할 때"),
            @ApiResponse(responseCode = "400", description = "인증 코드가 일치하지 않을 때")
    })
    @PostMapping("/verifyCode")
    public ResponseEntity<String> verifyCode(@RequestBody VerificationDto verificationDto, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String verificationCode = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("verificationCode")) {
                    verificationCode = cookie.getValue();
                    break;
                }
            }
        }

        // 쿠키에 저장된 코드 출력
        System.out.println("Stored Code in Cookie: " + verificationCode);
        // 사용자가 입력한 코드 출력
        System.out.println("User Input Code: " + verificationDto.getCode());

//        if (verificationCode == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인증 코드가 존재하지 않습니다.");
//        } else if (!verificationCode.equals(verificationDto.getCode())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("인증 코드가 일치하지 않습니다.");
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).body("인증 코드가 확인되었습니다.");
//        }
        if (verificationCode == null) {
//            throw new InvalidVerificationCodeException("인증 코드가 존재하지 않습니다.");
            throw new UserException(ErrorCode.NOTMAIL);
        } else if (!verificationCode.equals(verificationDto.getCode())) {
//            throw new InvalidVerificationCodeException("인증 코드가 일치하지 않습니다.");
            throw new UserException(ErrorCode.NOEQULMAIL);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("인증 코드가 확인되었습니다.");
//            throw new UserException(ErrorCode.VERIFYMAIL);
        }
    }


}
