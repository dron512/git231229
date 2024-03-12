package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Schema(description = "User Table 에 대한 내용입니다.")
public class User {

    // SEQUENCE 테이블을 생성해서 기본키 관리..
    // IDENTITY AUTO_INCREMENT 자동증가

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 ID",description = "table에서 자동으로 생성되는 컬럼입니다.")
    private Long id;

    @Column(length = 50)
    @Schema(title = "사용자 username", description = "사용자 이름을 넣어주시면 됩니다.")
    private String username;

    @Column(length = 50, unique = true)
    private String email;

    @JsonIgnore
    private String password;

    // @Enumerated(EnumType.ORDINAL) male = 0 , female = 1
    // @Enumerated(EnumType.STRING) => Male,feMale
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Posts> postsList;

}
