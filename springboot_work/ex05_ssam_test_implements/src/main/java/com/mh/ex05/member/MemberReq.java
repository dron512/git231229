package com.mh.ex05.member;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberReq {
    private String email;
    private String password;
    private String confirmpassword;
}
