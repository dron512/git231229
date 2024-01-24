package com.mh.mybatistest.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.mybatistest.member.Member;
import com.mh.mybatistest.member.MemberController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@Slf4j
public class MybatistestUnitTest {

    @Mock
    private MockMvc mockMvc;

    @MockBean
    MemberController memberController;

    @Test
    void createUser() throws Exception{
        Member member = Member.builder()
                .name("홍길동")
                .password("password")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(member);

        log.info(userJson);

//        when(memberController.doA()).thenReturn(userJson);

        mockMvc.perform(post("/aa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(result -> System.out.println(result));
    }
}
