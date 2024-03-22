package com.mh.restapi05.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OperationCustomizer operationCustomizer() {
        return (operation, handlerMethod) -> {
            operation.addParametersItem(
                    new Parameter()
                            .in(ParameterIn.HEADER.toString())
                            .required(true)
                            .description("api를 사용하기 위한 인증키")
                            .name("Authorization")
                            .example("TEST_API_KEY")
            );

            return operation;
        };
    }
}
