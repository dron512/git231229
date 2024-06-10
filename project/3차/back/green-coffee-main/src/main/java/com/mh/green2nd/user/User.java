package com.mh.green2nd.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mh.green2nd.orders.Order;
import com.mh.green2nd.store.Store;
import com.mh.green2nd.pay.Pay;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    @Schema(title = "user_id",description = "인덱스")
    private Long user_id;

    @Column(name = "email", nullable = false, unique = true)
    @Schema(title = "이메일",description = "이메일 입력")
    private String email;

    @Column(name = "password", nullable = false)
    @Schema(title = "패스워드",description = "패스워드 입력부분입니다")
    private String password;

    @Column()
    @Schema(title = "닉네임",description = "닉네임 입력부분입니다")
    private String nickname;

    @Column()
    @Schema(title = "휴대폰")
    private String phone;

    @Column()
    @Schema(title = "생년월일")
    private String birthdate;

    @Enumerated(EnumType.STRING)
    @Schema(title = "탈퇴여부")
    @JsonIgnore
    @Builder.Default
    private Resign resign = Resign.N;

    private LocalDateTime resignDate;

    @Enumerated(EnumType.STRING)
    @Schema(title = "로그인상태")
    @Builder.Default
    private Loginstate loginstate = Loginstate.Y;

    @Enumerated(EnumType.STRING)
    @Schema(title = "권한")
    @Builder.Default
    private Role role = Role.USER;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @Column(columnDefinition = "integer default 0")
    @Schema(title = "쿠폰",description = "보유쿠폰 몇장이면?")
    private int coupon;

    @Column(columnDefinition = "integer default 0")
    @Schema(title = "보유스탬프",description = "몇 장 있는지 숫자넣음")
    private int stamp;

    @Schema(title = "토큰")
    private String token;

    @Column(name = "verification_code")
    private String verificationCode;

    private String refreshToken;

    @OneToMany
    private List<Order> orderlist;

    @OneToMany(mappedBy = "user")
    private List<Pay> pay = new ArrayList<>();

    public void addPay(Pay pay) {
        this.pay.add(pay);
        pay.setUser(this);
    }

}
