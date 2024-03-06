package org.example.studyspringbootsecurity.domain.member.constant;

public enum Role {

    USER, ADMIN;

    public static Role from(String role) {
        return Role.valueOf(role);
    }

}
