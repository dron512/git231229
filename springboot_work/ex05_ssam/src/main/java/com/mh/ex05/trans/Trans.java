package com.mh.ex05.trans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trans {

    // idx 라는 기본키 만들고 값은 자동으로 넣어서 해줘...
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long idx;

    private String source;
    private String target;
}
