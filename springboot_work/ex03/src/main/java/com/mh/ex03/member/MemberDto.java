package com.mh.ex03.member;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class MemberDto {

    private int idx;
    private String email;
    private String password;
    private String gender;
    
}
