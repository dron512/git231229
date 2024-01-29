package com.mh.ex04.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MemberReq {

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private String gender;
}
