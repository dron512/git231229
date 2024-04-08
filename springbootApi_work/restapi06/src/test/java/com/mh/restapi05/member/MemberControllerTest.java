package com.mh.restapi05.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc // MockMvc를 사용하기 위한 어노테이션
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    MemberService memberService;

    @Test
    void getmember() throws Exception {
        Member member1 = Member.builder()
                .id(1L)
                .username("John Doe")
                .email("aaa@naver.com")
                .password("1234")
                .build();
        Member member2 = Member.builder()
                .id(2L)
                .username("bbb")
                .email("bbb@naver.com")
                .password("1234")
                .build();

        List<Member> members = Arrays.asList(member1, member2);

        given(memberService.getAllMembers()).willReturn(members);


        ResultActions resultActions = mockMvc.perform(
                                        MockMvcRequestBuilders.get("/member")
                                        .contentType(MediaType.APPLICATION_JSON));

        System.out.println(resultActions.andDo(print()));

        resultActions
                .andExpect(status().isOk());

        resultActions.andReturn().getResponse().getContentAsString();
        /*
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[0].email").value("john.doe@example.com"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Jane Smith"))
                .andExpect(jsonPath("$[1].email").value("jane.smith@example.com"));
         */
    }

    @Test
    void postmember() throws Exception {
        Member member = Member.builder()
                .id(1L)
                .username("John Doe")
                .email("aaa@naver.com")
                .password("1234")
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonMember = objectMapper.writeValueAsString(member);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/member")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonMember));

        resultActions
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.email").value("aaa@naver.com"));
    }
}