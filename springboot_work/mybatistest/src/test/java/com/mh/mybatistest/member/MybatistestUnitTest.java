package com.mh.mybatistest.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.mybatistest.member.Member;
import com.mh.mybatistest.member.MemberController;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.regex.Matcher;


@Slf4j
@WebMvcTest
public class MybatistestUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @Test
    void createUser() throws Exception{
        assertNotNull(memberService);

        Member member = Member.builder()
                .email("aaa@naver.com")
                .password("password")
                .build();
        String content = new ObjectMapper().writeValueAsString(member);
        when(memberService.save(member)).thenReturn("save success");

        // when (테스트 실행)
        ResultActions resultActions =
                mockMvc.perform(post("/save").contentType(MediaType.APPLICATION_JSON)
                .content(content).accept(MediaType.APPLICATION_JSON));

        // then (검증)
        resultActions.andExpect(status().isOk())
                .andExpect(result -> System.out.println(result))
                .andDo(MockMvcResultHandlers.print());
    }



}
