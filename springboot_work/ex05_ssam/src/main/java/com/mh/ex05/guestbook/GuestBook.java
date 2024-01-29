package com.mh.ex05.guestbook;

import com.mh.ex05.entity.BaseTimeEntity;
import com.mh.ex05.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GuestBook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;
    private String content;

    @ManyToOne
    @JoinColumn(name="member_idx")
    private Member member;

}
