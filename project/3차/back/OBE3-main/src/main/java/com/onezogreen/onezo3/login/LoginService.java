package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.manager.ManagerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    //로그인
    public ManagerVo logIn(String email, String password) {
        ManagerVo managerVo = new ManagerVo();
        managerVo.setEmail(email);
        managerVo.setPassword(password);
        ManagerVo dbmanager=loginMapper.loginSelect(managerVo);
        return dbmanager;
    }
}
