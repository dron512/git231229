package com.mh.restapi05.member;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    @Test
    public void dummy() {
        for (Role role : Role.values()) {
            System.out.println(role);
        }
    }
}