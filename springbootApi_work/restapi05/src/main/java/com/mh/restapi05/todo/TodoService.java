package com.mh.restapi05.todo;

import com.mh.restapi05.member.Member;
import com.mh.restapi05.member.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    public TodoService(TodoRepository todoRepository, MemberRepository memberRepository) {
        this.todoRepository = todoRepository;
        this.memberRepository = memberRepository;
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo save(Long id, Todo todo) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Member not found"));
        todo.setMember(member);
        return todoRepository.save(todo);
    }

    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo update(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos(Long id) {
        Member member =  memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Member not found"));
        return todoRepository.findAllByMember(member);
    }
}
