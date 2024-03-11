package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    // SEQUENCE 테이블을 생성해서 기본키 관리..
    // IDENTITY AUTO_INCREMENT 자동증가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String username;

    @Column(length = 50, unique = true)
    private String email;

    private String password;

    // @Enumerated(EnumType.ORDINAL) male = 0 , female = 1
    // @Enumerated(EnumType.STRING) => Male,feMale
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

}
