package com.mh.green2nd.store;

import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "store")
@Data
@RequiredArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "open")
    private String open;

    @Column(name = "close")
    private String close;

    @Column(name = "holiday")
    @Schema(defaultValue = "화요일")
    private String holiday;

    @Column(name = "status", nullable = false)
    @Schema(description = "영업중, 영업끝, 휴무중")
    private String status;

    @Column(name = "admin_name")
    @Schema(description = "매장 관리자 이름")
    private String adminName;

    @OneToOne(mappedBy = "store")
    private User user;

}
