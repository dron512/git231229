package com.example.mateproject.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Status {

    private int id;
    private int todo_id;
    private String todo_content;
    private String status;

    private Todolist todolist;
}
