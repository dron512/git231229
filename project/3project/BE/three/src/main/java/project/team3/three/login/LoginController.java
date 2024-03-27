package project.team3.three.login;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import project.team3.three.user.User;
import project.team3.three.user.UserDto;
import project.team3.three.user.UserService;

import java.io.PushbackReader;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final TokenManager tokenManager;

    // 회원가입
    // 이메일, 전화번호 중복체크도 같이 실행
    @PostMapping("/signUp")
    public boolean UserSignUp(@RequestBody UserDto userDto){
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto,User.class);
        loginService.signUp(user);
        return true;
    }
    
    // 로그인
    // jwt 발행(난 발행만 해주고 로그인한 유저만 갈 수 있는 경로로갈 때 토큰을 넣을 수 있도록 프론트에 알려야한다)
    @PostMapping("/signIn")
    public String token(@RequestBody UserDto userDto){
        System.out.println("email = " + userDto.getEmail());
        System.out.println("password = " + userDto.getPassword());
        User dbUser = loginService.signIn(userDto.getEmail(), userDto.getPassword());
        if(dbUser == null){
            throw new RuntimeException("회원가입이 안되어져 있습니다.");
        }
        return tokenManager.generateToken(dbUser);
    }

    // 아이디(이메일) 찾기
    @PostMapping("/findId")
    public Optional<String> findId(@RequestBody UserDto userDto){
        System.out.println("이름 : " + userDto.getName());
        System.out.println("학과 : " + userDto.getStudies());
        System.out.println("전화번호 : " + userDto.getPhoneNum());

        Optional<String> userId = loginService.findByNameAndStudiesAndPhoneNum(userDto.getName(), userDto.getStudies(), userDto.getPhoneNum());

        if(userId == null){
            throw new RuntimeException("일치하는 정보가 없습니다.");
        }
        return userId;
    }

    // 비밀번호 찾기
    @PostMapping("/findPw")
    public Optional<Long> findPw(@RequestBody UserDto userDto){
        System.out.println("이름 : " + userDto.getName());
        System.out.println("학과 : " + userDto.getStudies());
        System.out.println("전화번호 : " + userDto.getPhoneNum());
        System.out.println("이메일 : " + userDto.getEmail());

        Optional<Long> userPw = loginService.findByNameAndStudiesAndPhoneNumAndEmail(userDto.getName(), userDto.getStudies(), userDto.getPhoneNum(), userDto.getEmail());

        if(userPw == null){
            throw new RuntimeException("일치하는 정보가 없습니다.");
        }
        return userPw;
    }

    // 토큰실험
    @GetMapping("/auth")
    public String loginTest(Authentication authentication){
        System.out.println(authentication);
        // 로그인 되어있나
        System.out.println(authentication.isAuthenticated());
        // jws.getPayload().get("username") 가져오는 이름
        System.out.println(authentication.getPrincipal());
        return "loginTest";
    }
}
