package org.example.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDto {

    private String email;
    private String name;
    private String password;
    private String confirmPassword;

    public boolean isEqualPassword(){
        return password.equals(confirmPassword);
    }
}
