package com.mh.restapi05.member;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 사용하기 위한 어노테이션
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService.save(Member.builder()
                        .username("홍길동")
                        .password("1234")
                        .role(Role.USER)
                        .email("user").build());
    }

    @Test
    @WithMockUser(username = "user", roles = "USER")
    void member() throws Exception {


        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/member"));
        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("user"))
                .andExpect(jsonPath("$[0].password").value("1234"));
        ;
    }

}