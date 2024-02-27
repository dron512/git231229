package org.example.member;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@Builder
public class Member {
    private Long id;
    private String email;
    private String name;
    private String password;
    private LocalDateTime wdate;

//    public Member(Long id, String email, String name, String password, LocalDateTime wdate) {
//        this.id = id;
//        this.email = email;
//        this.name = name;
//        this.password = password;
//        this.wdate = wdate;
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", wdate=" + wdate +
//                '}';
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public LocalDateTime getWdate() {
//        return wdate;
//    }
//
//    public void setWdate(LocalDateTime wdate) {
//        this.wdate = wdate;
//    }
}
