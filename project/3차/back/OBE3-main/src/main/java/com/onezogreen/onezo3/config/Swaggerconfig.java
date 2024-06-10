package com.onezogreen.onezo3.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "onezo3rd BackEnd"
                , description = "원조치킨 프렌차이즈 관리자 기능"
                , version = "v1.0.1"
        )
)

@Configuration
public class Swaggerconfig {

        @Bean
        public GroupedOpenApi User(){
                String[] paths = {"/**"};
                return GroupedOpenApi.builder()
                        .group("User Management")
                        .pathsToMatch(paths)
                        .build();
        }
        @Bean
        public OpenAPI openAPI() {
                // SecurityScheme 설정
                String jwtSchemeName = "accessToken";
                SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
                Components components = new Components()
                        .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                                .name(jwtSchemeName)
                                .type(SecurityScheme.Type.HTTP) // HTTP 방식
                                .scheme("bearer")
                                .bearerFormat("JWT"));
                return new OpenAPI()
                        .components(components)
                        .addSecurityItem(securityRequirement);
        }


}
