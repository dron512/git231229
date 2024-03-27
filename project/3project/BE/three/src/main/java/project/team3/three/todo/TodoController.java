package project.team3.three.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("main")
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo") // 투두 등록
    public Todo InsertTodo(@RequestBody TodoDto todoDto){
        return todoService.insertTodo(todoDto);
    }
    @GetMapping("/todo/{id}") // id로 투두 찾기
    public Todo SelectTodo(@PathVariable Long id){
        return todoService.selectTodo(id);
    }
    @PutMapping("/todo/{id}") // id로 투두 업데이트
    public Todo UpdateTodo(@PathVariable Long id ,@RequestBody TodoDto todoDto){
        return todoService.updateTodo(id, todoDto);
    }
}
