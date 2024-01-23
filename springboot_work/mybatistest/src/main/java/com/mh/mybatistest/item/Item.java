package com.mh.mybatistest.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Item {

    @Id
    private Long id;
    private String name;


}
