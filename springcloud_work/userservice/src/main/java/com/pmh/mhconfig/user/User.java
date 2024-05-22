package com.pmh.mhconfig.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long user_idx;
    private String user_email;
    private String user_name;
    private String user_password;
}
