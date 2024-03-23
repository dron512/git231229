package org.example.studyspringbootsecurity.conf;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String id = request.getHeader("id");
        System.out.println("interceptor");
//        if(id == null)
//            throw new Exception();
//        else {
//            System.out.println(id);
//        }

        return true;
    }
}
