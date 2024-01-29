package org.example.member;

import lombok.*;

@Setter
@Getter // getter 메서드
@AllArgsConstructor // 생성자
@Builder
@ToString
public class Member {
    private String email;
    private String name;
    private String addr;
    private String password;
    private String role;
}
