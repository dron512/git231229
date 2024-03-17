package com.mh.restapi02.conf;

import com.mh.restapi02.interceptor.TokenInterceptor;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class TokenWebConfig implements WebMvcConfigurer {

    private final TokenInterceptor tokenInterceptor;
    private final JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(tokenInterceptor)
//                .excludePathPatterns("/token");
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.authorizeHttpRequests(req->{
            req.anyRequest().permitAll()
            ;
        });

        // h2 console 보이게
        httpSecurity.headers( header->{
            header.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin());
        });

        httpSecurity.addFilterAfter(jwtAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
//        http.addFilterAt(loginProcessingFilter(authenticationManager()),
//                UsernamePasswordAuthenticationFilter.class);
        // 로그인 필터 앞에 JWT 인증 필터 추가

    }

    // AuthenticationEntryPoint 등록
}
