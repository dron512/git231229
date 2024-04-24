package com.green.onezo.member;

import com.fasterxml.jackson.annotation.JsonIgnore;


import com.green.onezo.enum_column.Resign_yn;
import com.green.onezo.enum_column.Role;
import com.green.onezo.pay.Pay;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, unique = true)
    private String ID;

    @JsonIgnore
    private String password;

    private String name;

    @Column(unique = true)
    private String nickname;

    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Resign_yn resign_yn;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member")
    private List<Pay> pays = new ArrayList<>();

    public void addPay(Pay pay) {
        pays.add(pay);
        pay.setMember(this);
    }
}
