package org.example.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {

    private long id;
    private String email;
    private String name;
    private String password;
    private String confirmPassword;
    private LocalDate localDate;

}
