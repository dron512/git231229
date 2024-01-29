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


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf->csrf.disable())
                .authorizeRequests(
                          req ->
                             req
                                     .requestMatchers("/css/**", "/js/**", "/img/**","/assets/**").permitAll()
                                     .requestMatchers("/auth/**").permitAll()
                                     .requestMatchers("/").permitAll()
                                     .requestMatchers("/guestbookapi/**").permitAll()
                                     .requestMatchers("/h2-console/**").permitAll()
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
