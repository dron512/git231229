package com.onezogreen.onezo3.login;

import com.onezogreen.onezo3.manager.ManagerVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    ManagerVo loginSelect(ManagerVo managerVo);

    void selectUserByEmail(String email);
}
