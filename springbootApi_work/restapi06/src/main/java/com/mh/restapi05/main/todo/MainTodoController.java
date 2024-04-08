package com.mh.restapi05.main.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main")
public class MainTodoController {

    @GetMapping("todo")
    public String todo() {
        return "todo/todo";
    }
}
