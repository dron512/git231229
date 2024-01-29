package com.mh.ex04.member;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {

    private int idx;
    private String email;
    private String password;
    private String gender;
}
