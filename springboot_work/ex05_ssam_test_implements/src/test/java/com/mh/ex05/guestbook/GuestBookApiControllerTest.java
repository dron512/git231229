package com.mh.ex05.guestbook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestBookApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void 조회하기() throws Exception {
        mockMvc.perform(get("/guestbookapi/list")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].content").value("aa@naver.com이 작성함"));
    }


}