package com.mh.restapi05.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("todo")
    public String todo(){
        return "todo";
    }
}
