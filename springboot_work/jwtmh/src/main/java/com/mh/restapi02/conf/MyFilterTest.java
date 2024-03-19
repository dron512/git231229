package com.mh.restapi02.conf;


import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilterTest implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterTest init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilterTest run");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterTest destroy");
    }
}
