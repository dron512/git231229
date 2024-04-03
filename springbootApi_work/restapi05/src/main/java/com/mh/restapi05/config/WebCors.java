package com.mh.restapi05.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebCors implements WebMvcConfigurer {

    private final JWTInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/token"
                        ,"/member/join"
                        ,"/swagger-ui/**"
                        ,"/swagger-ui/**/**"
                        ,"/swagger-resources/**"
                        ,"/swagger-resources/**/**"
                        ,"/v2/api-docs"
                        ,"/v3/api-docs"
                        ,"/h2-console/**"
                        ,"/main/**"
                        ,"/error"
                        ,"index.html"
                        ,"");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.PATCH.name(),
                        HttpMethod.DELETE.name(),
                        HttpMethod.OPTIONS.name()
                )
                .maxAge(3600);
    }
}
