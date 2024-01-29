package com.mh.ex04.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void list() throws Exception {

    }

    @Test
    void writeform() {
    }

    @Test
    void writeproc() {
    }

    @Test
    void updateform() {
    }

    @Test
    void updateproc() {
    }

    @Test
    void view() {
    }

    @Test
    void delete() {
    }

    @Test
    void downloadAttach() {
    }
}