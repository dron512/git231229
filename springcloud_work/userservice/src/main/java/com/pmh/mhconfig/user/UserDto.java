package com.pmh.mhconfig.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)// NULL인거 안나오게 하는거
public class UserDto {

    private long user_idx;
    @NotBlank
    private String user_email;
    private String user_name;

    @Schema(hidden = true)
    private String user_password;

}

