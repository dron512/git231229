package com.mh.restapi05.todo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.restapi05.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String todo;

    @ManyToOne
//    @JoinColumn(name = "mem_id")
    @JsonIgnore
    private Member member;

}
