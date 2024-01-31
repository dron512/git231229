package com.mh.ex05.guestbook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
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


    @Test
    void 한개조회하기() throws Exception {

        long idx = 2l;
        mockMvc.perform(get("/guestbookapi/get/" + idx).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());


    }

    @Test
    void postsave() throws Exception {
        GuestBook gb = GuestBook.builder()
                .content("새로 만들기").build();

        String gbjson = new ObjectMapper().writeValueAsString(gb);
        System.out.println(gbjson);

        mockMvc.perform(post("/guestbookapi/save").contentType(MediaType.APPLICATION_JSON)
                        .content(gbjson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void putsave() throws Exception {
        GuestBook gb = GuestBook.builder()
                .content("새로 만들기").build();

        String gbjson = new ObjectMapper().writeValueAsString(gb);
        System.out.println(gbjson);

        mockMvc.perform(post("/guestbookapi/save").contentType(MediaType.APPLICATION_JSON)
                        .content(gbjson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        GuestBook ugb = GuestBook.builder()
                .content("수정 만들기").build();

        String gbujson = new ObjectMapper().writeValueAsString(ugb);

        mockMvc.perform(put("/guestbookapi/update").contentType(MediaType.APPLICATION_JSON)
                        .content(gbujson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void delete삭제하기() throws Exception{
        GuestBook gb = GuestBook.builder()
                .content("새로 만들기").build();

        String gbjson = new ObjectMapper().writeValueAsString(gb);
        System.out.println(gbjson);

        mockMvc.perform(post("/guestbookapi/save").contentType(MediaType.APPLICATION_JSON)
                        .content(gbjson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        GuestBook dgb = GuestBook.builder()
                .idx(1l).build();

        String gbdjson = new ObjectMapper().writeValueAsString(dgb);
        System.out.println(gbjson);

        mockMvc.perform(delete("/guestbookapi/delete").contentType(MediaType.APPLICATION_JSON)
                        .content(gbdjson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}