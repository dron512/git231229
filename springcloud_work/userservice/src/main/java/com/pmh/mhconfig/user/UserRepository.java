package com.pmh.mhconfig.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    void save(User user);

    @Insert("insert into users" +
    "        (user_email,user_name,user_password)" +
    "        values" +
    "        (#{user_email},#{user_name},#{user_password})")
    void save2(User user);
}
