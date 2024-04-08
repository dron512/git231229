package com.mh.restapi05;

import com.mh.restapi05.member.Member;
import com.mh.restapi05.member.MemberRepository;
import com.mh.restapi05.member.Role;
import com.mh.restapi05.todo.Todo;
import com.mh.restapi05.todo.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    void name() {

        Member member = Member.builder()
                .username("test")
                .password("test")
                .email("test")
                .role(Role.USER)
                .build();

        memberRepository.save(member);

        for (int i = 1; i < 4; i++) {
            Todo todo = new Todo((long)i,"test" + i,  member);
            todoRepository.save(todo);
        }

        System.out.println(memberRepository.findById(1l).get());
        System.out.println(todoRepository.findAll().size());

        assertEquals(3, todoRepository.findAll().size());

    }
}