package com.mh.restapi05.config;

import com.mh.restapi05.member.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class WebFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("필터 동작");

//        request.getRequestURI().contains("token")

        // 서버에 해당되는 id,password 가 맞으면... 그담
        String myheader = request.getHeader("my-header");
        System.out.println(myheader);

        // 그다음으로 이동해서 진행해라... member, test, todo
        filterChain.doFilter(request, response);
    }

}
