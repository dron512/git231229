package com.mh.restapi05.jwt;


import lombok.Data;

@Data
public class TokenDto {
    private String email;
    private String password;
}
