package project.team3.three.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Todo insertTodo(TodoDto todoDto){
        Todo todo = new Todo();
        todo.setTodo(todoDto.getTodo());
        return todoRepository.save(todo);
    }
    public Todo selectTodo(Long id){
        return todoRepository.findById(id).orElse(null);
    }
    public Todo updateTodo(Long id, TodoDto todoDto){
        Todo todo = todoRepository.findById(id).orElse(null);
        if(todo != null){
            todo.setTodo(todoDto.getTodo());
            return todoRepository.save(todo);
        }
        return null;
    }



}
