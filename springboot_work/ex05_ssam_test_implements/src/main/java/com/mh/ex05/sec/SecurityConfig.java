package com.mh.ex05.sec;

import com.mh.ex05.member.Member;
import com.mh.ex05.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    MemberRepository memberRepository;

    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/guestbookapi/**");
    }

    CorsConfigurationSource apiConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(List.of("http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setExposedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf->csrf.disable())
                .cors(cors -> {
                    cors.configurationSource(apiConfigurationSource());
                })
                .authorizeRequests(
                          req ->
                             req.requestMatchers(
                                             "/css/**",
                                             "/js/**",
                                             "/img/**",
                                             "/assets/**",
                                             "/auth/**",
                                             "/guestbook/**",
                                             "/error/**",
                                             "/guestbookapi/**",
                                             "/h2-console/**",
                                             "/swagger-ui/**",
                                             "v3/api-docs",
                                             "/").permitAll()
//                                     .requestMatchers("/member").hasRole("ADMIN")
                                .anyRequest().authenticated()
                     )
                .formLogin( login ->
                            login
                                .loginPage("/auth/login")
                                    .defaultSuccessUrl("/",true)
                                .usernameParameter("email")
                                    .failureUrl("/auth/login/error")
                                .permitAll() )
                .logout( logout->logout.logoutUrl("/auth/logout") )
                ;

        return http.build();
    }
}
