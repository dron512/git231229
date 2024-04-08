package com.mh.restapi05.member;

import com.mh.restapi05.common.BaseEntity;
import com.mh.restapi05.todo.Todo;
import jakarta.persistence.*;
import lombok.*;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

// DB 에 저장하는 클래스
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;
    private String password;
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    // ctrl + e 최근파일 목록 보여주기
    // shift shift 전체 파일검색
    // alt + 1 project 창으로 해당파일 선택할수도 있습니다.

    // USER, ADMIN
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Todo> boardList;


}
