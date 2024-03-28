package project.team3.three.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
    private Long id;
    private String todo;

    public TodoDto(Long id, String todo) {
        this.id = id;
        this.todo = todo;
    }
}
