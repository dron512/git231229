package com.mh.restapi03.login;

import com.mh.restapi03.exception.ErrorCode;
import com.mh.restapi03.exception.UsersException;
import com.mh.restapi03.users.User;
import com.mh.restapi03.users.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final UserRepository userRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("일로오나");
        System.out.println();
        Enumeration<String> enums = request.getHeaderNames();
        while (enums.hasMoreElements()) {
            String name = enums.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }
        String password = request.getHeader("password");
        String email = request.getHeader("email");

        System.out.println(password);
        System.out.println(email);

        if (password != null || email != null) {
            User dbUser = userRepository.findByEmailAndPassword(email, password);
            if (dbUser == null) {
                throw new UsersException(ErrorCode.lOGINFAILED);
            }
        }
        return true;
    }
}
