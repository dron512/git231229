package com.three.alcoholshoppingmall.project.user;

import static com.three.alcoholshoppingmall.project.exception.ErrorCode.DUPLPHONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.three.alcoholshoppingmall.project.conf.JWTInterceptor;
import com.three.alcoholshoppingmall.project.login.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.io.UnsupportedEncodingException;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Mock
    private UserService userService;
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    private JWTInterceptor jwtInterceptor;

    public String genToken() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Login login = new Login("k9315861@naver.com","a1234567!");

        //when
        ResultActions resultActions = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(login)));

        MvcResult mvcResult = resultActions.andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        // Assert the response
        return responseBody;
    }

    @Test
    @DisplayName("토큰 생성 테스트")
    public  void jwtTokenGeneration() throws Exception{
        // Given
        ObjectMapper objectMapper = new ObjectMapper();
        Login login = new Login("k9315861@naver.com","a1234567!");

        //when
        ResultActions resultActions = mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(login)));
        // 을 헤더에 추가
        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());

        MvcResult mvcResult = resultActions.andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();

        // Assert the response
        System.out.println("Response Body: " + responseBody);
    }


    @Test
    @DisplayName("회원정보수정성공테스트")
    public void UpdateUserSuccess() throws Exception {
        // Given
        UserUpdate userUpdate = new UserUpdate("k9315861", "01012341234", "대구", "달서구");
        when(userService.updateUser("k9315861@naver.com", userUpdate)).thenReturn("회원정보가 수정되었습니다");

        // When
        String response = userService.updateUser("k9315861@naver.com", userUpdate);

        // Then
        assertEquals("회원정보가 수정되었습니다", response);
    }

    @Test
    @DisplayName("회원정보 휴대폰 중복체크")
    public void UpdateUserPhoneAlreadyExists() throws Exception {
        // Given
        ObjectMapper objectMapper = new ObjectMapper();
        UserUpdate userUpdate = new UserUpdate("k9315861", "01011111111", "대구 ", "달서구");
        String token = genToken();
        String jwtToken = "Bearer "+token;

        //when
        ResultActions resultActions = mockMvc.perform(put("/user/updateUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(userUpdate))
                .header("Authorization", jwtToken)); // JWT 토큰
        // 을 헤더에 추가

        //then
        resultActions
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("DUPLPHONE"))
                .andExpect(jsonPath("$.errorMessage").value("이미 가입된 번호입니다."))
                .andDo(print());
    }

//    @Test
//    @DisplayName("회원정보 휴대폰 중복체크")
//    public void UpdateUserPhoneAlreadyExists() throws Exception {
//        // Given
//        ObjectMapper objectMapper = new ObjectMapper();
//        UserUpdate userUpdate = new UserUpdate("k9315861", "01012341234", "대구 달서구", "조암로 6길 20 103동");
//        String token = genToken();
//        String jwtToken = "Bearer " + token;
//
//        // When
//        ResultActions resultActions = mockMvc.perform(put("/user/updateUser")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(objectMapper.writeValueAsString(userUpdate))
//                .header("Authorization", jwtToken));
//
//        // Then
//        resultActions
//                .andExpect(status().isOk()) // 응답 코드 확인 (200 OK)
//                .andExpect(jsonPath("$.error").value("DUPLPHONE_ERROR")) // 실제 API에서 사용하는 에러 코드 명칭 사용
//                .andExpect(jsonPath("$.errorMessage").value("이미 가입된 번호입니다."))
//                .andDo(print());
//    }
}
