package com.mh.restapi05.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/{id}/findAll")
    public ResponseEntity<List<Todo>> todoAll(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(todoService.getAllTodos(id));
    }

    @GetMapping("/{id}/findOne")
    public ResponseEntity<Todo> todoOne(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(todoService.getTodoById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Todo> todo(@PathVariable Long id, @RequestBody Todo todo)
    {
        return ResponseEntity.ok().body(todoService.save(id,todo));
    }

}
