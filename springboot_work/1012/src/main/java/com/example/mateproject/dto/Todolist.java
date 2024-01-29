package com.example.mateproject.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Todolist {

    private int id;
    private String member_id;
    private String content;
    private Date goalDate;
    private Date finishDate;

    private Member member;

}