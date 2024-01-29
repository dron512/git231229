package com.mh.ex05.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        (authorizeRequests) -> authorizeRequests
                                .requestMatchers("/css/**", "/js/**", "/img/**","/assets/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/main.html").permitAll()
//                                .requestMatchers("/", "/members/**", "/item/**", "/images/**").permitAll()
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()

                )
                .formLogin(
                        (formLogin) -> formLogin
                                .loginPage("/auth/login")
                                .defaultSuccessUrl("/",true)
                                .usernameParameter("email")
                                .failureUrl("/auth/login/error")
                                .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/auth/logout"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
