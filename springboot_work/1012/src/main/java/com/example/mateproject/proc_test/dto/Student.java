package com.example.mateproject.proc_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private int student_id;
    private String student_name;
    private int student_age;
}
