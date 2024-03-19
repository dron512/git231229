package com.mh.restapi05.exception;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String reason;

}
