package com.mh.mybatistest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
class User {
    private String name;
    private String password;
}
