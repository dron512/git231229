package com.mh.mybatistest.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private String name;
    private String password;
}
