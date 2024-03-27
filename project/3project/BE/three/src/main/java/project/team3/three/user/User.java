package project.team3.three.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Schema(description = "user 테이블에 대한 내용입니다.")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 ID",description = "table에서 자동으로 생성되는 컬럼입니다.")
    private Long userId;


    @Schema(title = "사용자 이름", description = "사용자 이름을 넣어주시면 됩니다.")
    private String name;

    @Column(unique = true)
    @Schema(title = "사용자 닉네임", description = "사용자 닉네임을 넣어주시면 됩니다.")
    private String nickname;

    @Column(unique = true)
    @Schema(title = "사용자 전화번호", description = "사용자 전화번호를 넣어주시면 됩니다.")
    private String phoneNum;

    @Column(unique = true)
    @Schema(title = "사용자 email", description = "사용자 이메일이 겹치지 않게 해줍니다.")
    private String email;

    @JsonIgnore
    @Column(unique = true)
    @Schema(title = "사용자 비밀번호", description = "사용자 비밀번호는 출력시에 무시되어 출력되지 않습니다.")
    private String password;


    @Schema(title = "사용자 studies", description = "사용자 학과를 넣어주시면 됩니다.")
    private String studies;

    @Enumerated(EnumType.STRING)
    @Schema(title = "사용자 재학여부", description = " 사용자의 재학여부를 확인하는 컬럼입니다.")
    private EnrollmentStatus enrollmentStatus;

    @Enumerated(EnumType.STRING)
    @Schema(title = "학년", description = " 사용자의 학년을 확인하는 컬럼입니다.")
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Schema(title = "사용자 회원탈퇴여부", description = " 사용자의 회원탈퇴여부를 확인하는 컬럼입니다.")
    private WithdrawStatus withdrawStatus;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Schema(title = "생성일자", description = "생성일자가 출력되는 칼럼입니다.")
    private LocalDateTime createDate;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(nullable = true)
    @Schema(title = "수정일자", description = "수정일자가 출력되는 칼럼입니다.")
    private LocalDateTime modifyDate;
}
