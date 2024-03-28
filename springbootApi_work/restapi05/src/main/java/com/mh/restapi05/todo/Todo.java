package com.mh.restapi05.todo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.restapi05.member.Member;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String todo;

    @ManyToOne
//    @JoinColumn(name = "mem_id")
    @JsonIgnore
    private Member member;

}
