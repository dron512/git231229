package com.green.onezo.member;


import com.green.onezo.jwt.JwtTokenDto;
import com.green.onezo.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {
    private final JwtUtil jwtUtil;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    //회원가입
    @PostMapping("signUp")
    public ResponseEntity<MemberDTO> signup(
            @RequestBody @Valid MemberDTO memberDTO
//            BindingResult bindingResult
    ) {
        System.out.println("일로오나");

//        if(bindingResult.hasErrors()){
//            // memberDto 유효성이 안맞아서 hasError가 되면
//            // 프론트 쪽에다가 memberDTO
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(memberDTO);
//        }
        memberService.signup(memberDTO);
        return ResponseEntity.ok(new MemberDTO());
    }

    //로그인 기능
    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody MemberDTO memberDTO) {
        String memberId = memberDTO.getID();
        String password = memberDTO.getPassword();

        Optional<Member> isAuthenticated = memberService.authenticate(memberId, password);

        if (isAuthenticated.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } else {
            JwtTokenDto jwtTokenDto = JwtTokenDto.builder()
                    .accessToken(jwtUtil.generateAccessToken(isAuthenticated.get()))
                    .refeshToken(jwtUtil.generateRefreshToken(isAuthenticated.get()))
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(
                    jwtTokenDto);
        }
    }
}
