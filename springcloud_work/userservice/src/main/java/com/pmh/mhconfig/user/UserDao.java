package com.pmh.mhconfig.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDao {
    private long user_idx;
    @NotBlank
    private String user_email;
    private String user_name;
    private String user_password;
}

