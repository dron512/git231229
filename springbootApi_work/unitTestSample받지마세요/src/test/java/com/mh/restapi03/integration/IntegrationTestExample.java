package com.mh.restapi03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.restapi03.users.User;
import com.mh.restapi03.users.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTestExample {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testIntegration() throws Exception{

        User user = new User();
        user.setId(1l);
        user.setUsername("John Doe");
        user.setEmail("john@example.com");

        ObjectMapper objectMapper = new ObjectMapper();

        // 통합 테스트 시나리오를 작성합니다.
        String url = "http://localhost:" + port + "/users"; // 실제 서버의 URL을 가져옵니다.

        // 예제로 GET 요청을 보내고 응답을 확인합니다.
        when(userRepository.findAll()).thenReturn(List.of(user));

        ResultActions resultActions = mockMvc.perform(get("/users"))
                .andExpect(status().isOk());

        // 응답 본문의 내용을 확인합니다.
        String content = resultActions.andReturn().getResponse().getContentAsString();
        User[] users = objectMapper.readValue(content, User[].class);
        assertEquals(1, users.length);
        assertEquals("John Doe", users[0].getUsername());
    }
}
