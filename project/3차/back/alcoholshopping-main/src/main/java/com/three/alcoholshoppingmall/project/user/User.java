package com.three.alcoholshoppingmall.project.user;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user")
@Schema(description = "user 테이블에 대한 내용입니다.")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "생성 번호", description = "table에서 자동으로 생성되는 칼럼입니다.")
    @Column(unique = true,nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    @Schema(title = "email", description = "회원의 email입니다.")
    private String email;

    @Schema(title = "nickname", description = "회원의 nickname입니다.")
    @Column(nullable = false, length = 50)
    private String nickname;

    @Schema(title = "password", description = "회원의 password입니다.")
    private String password;

    @Schema(title = "address", description = "회원의 주소 입니다.")
    @Column(nullable = false)
    private String address;

    @Schema(title = "address2", description = "회원의 상세주소 입니다.")
    @Column(nullable = false)
    private String address2;

    @Schema(title = "gender", description = "회원의 성별 입니다.")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Schema(title = "birthdate", description = "회원의 생년월일 입니다.")
    @Column(nullable = false, length = 8)
    private String birthdate;

    @Schema(title = "phone", description = "회원의 전화번호 입니다.")
    @Column(nullable = false,unique = true, length = 20)
    private String phone;

    @Schema(title = "withdraw", description = "회원의 탈퇴 입니다.")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("'N'")
    private WithdrawStatus withdrawStatus;

    @Schema(title = "createDate", description = "회원 생성일자 입니다.")
    @CreationTimestamp
    private LocalDate createDate;

    @Schema(title = "modifiedDate", description = "회원 정보수정일자 입니다.")
    @UpdateTimestamp
    private LocalDate modifiedDate;

    @Schema(title = "tempPw", description = "임시 비밀번호 입니다.")
    private String tempPw;
}


