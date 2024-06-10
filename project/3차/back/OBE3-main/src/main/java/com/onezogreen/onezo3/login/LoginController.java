package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final TokenManager tokenManager;


    @Operation(summary = "로그인",description = "db에 존재하는 아이디와 비밀번호를 사용해 로그인")
    @PostMapping("/login")
    public ResponseEntity token(@RequestBody LoginRequest loginRequest) {
        ManagerVo managerVo=loginService.logIn(loginRequest.getEmail(), loginRequest.getPassword());
        if(managerVo==null){
            throw new RuntimeException("회원이 아닙니다.");
        }
        String token = tokenManager.generateToken(managerVo);
//        JwtTokenDto jwtTokenDto = new JwtTokenDto(tokenManager.generateToken(managerVo));
        LoginResponse loginResponse=new LoginResponse( managerVo.getStore_id(),token);

        return ResponseEntity.ok(loginResponse);
    }

}
