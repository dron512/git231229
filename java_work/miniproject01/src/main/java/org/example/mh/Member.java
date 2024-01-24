package org.example.mh;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter // getter 메서드
@AllArgsConstructor // 생성자
public class Member {
    private String email;
    private String name;
    private String addr;
    private String password;
}
