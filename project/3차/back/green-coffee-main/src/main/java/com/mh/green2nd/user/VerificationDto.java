package com.mh.green2nd.user;

import lombok.Data;

@Data
public class VerificationDto {
    private String email;
    private String code;

}

