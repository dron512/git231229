package com.mh.restapi05.config;

import com.mh.restapi05.main.member.MainMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final MainMemberService mainMemberService;


    // 스프링 부트 3 버전 람다문법을 써야지만 에러가 안납니다.
    // jwt 토큰 인증을 달겠다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // post 방식 put 방식 delete 방식을 사용할때 csrf 토큰을 사용하지 않겠다.
        // 허용해주겠다..

        http.userDetailsService(mainMemberService);

        // userDetailService
        http.csrf(httpSecurityCsrfConfigurer ->  httpSecurityCsrfConfigurer.disable() );
        http.formLogin(
                fr -> fr.loginPage("/main/login")
                        .defaultSuccessUrl("/main/main")
                        .usernameParameter("email")
//                        .passwordParameter("password")
                        .failureUrl("/main/login?error")
        );

        http.logout(
                // logout 페이지 지정
                logout -> logout.logoutUrl("/main/logout")
                // 성공적으로 logout시에 main/main페이지로 이동
                .logoutSuccessUrl("/main/main")
        );

        http
                .authorizeRequests(
                   req ->
                        req
                                .requestMatchers("/main/login",
                                                "/main/login?error",
                                                "/main/logout",
                                                "/main/join",
                                                "/error",
                                                "/main/main"
                                        ).permitAll()
                                .anyRequest().authenticated()
//                        req->
//                                req.anyRequest().permitAll()
                )
        ;

        // h2 console 사용하는 구문
        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
                frameOptionsConfig -> frameOptionsConfig.sameOrigin()
        ));

        // Exceptionhandling ->
        // 스프링시큐리티에서 필터를 다는 방법

        // http.addFilter(filter);

        // 인터셉터
        // http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        // 유저 관리 하는 매니저 클래스
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//
//        // 로그인 할수 있는 유저 생성
//        UserDetails userDetails = User.withUsername("user")
//                .password(passwordEncoder().encode("1234"))
//                .roles("USER")
//                .build();
//
//        // 유저관리 하는 매니저 클래스에 유저 등록
//        userDetailsManager.createUser(userDetails);
//
//        // 유저관리 하는 매니저 IOC 컨테이너에 등록 -> securityConfig에서 사용
//        return userDetailsManager;
//    }

}
