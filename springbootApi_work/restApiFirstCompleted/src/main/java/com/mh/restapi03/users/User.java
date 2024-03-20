package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

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

    // User admin
    private String grade;

    // @Enumerated(EnumType.ORDINAL) male = 0 , female = 1
    // @Enumerated(EnumType.STRING) => Male,feMale
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(updatable = true, name = "wdate")
    private LocalDateTime wdate;

}
