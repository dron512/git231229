package com.onezogreen.onezo3.manager;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerVo {
    private String email;
    private String password;
    private Long manager_id;
    private Long store_id;
}
