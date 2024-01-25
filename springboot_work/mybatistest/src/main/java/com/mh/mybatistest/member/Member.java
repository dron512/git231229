package com.mh.mybatistest.member;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class Member {
    private String email;
    private String name;
    private String password;
}
