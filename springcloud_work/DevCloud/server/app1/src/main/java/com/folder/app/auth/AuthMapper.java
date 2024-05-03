package com.folder.app.auth;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {

  public User findById(String name);

}
