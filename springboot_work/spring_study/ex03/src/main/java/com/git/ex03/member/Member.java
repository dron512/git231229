package com.git.ex03.member;

import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Member {

    private int idx;
    private String email;
    private String password;
    private LocalDate localDate;

}
