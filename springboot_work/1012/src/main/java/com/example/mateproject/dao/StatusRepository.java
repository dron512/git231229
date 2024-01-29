package com.example.mateproject.dao;

import com.example.mateproject.dto.Status;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepository {


    @Autowired
    SqlSession sqlSession;

    public List<Status> doSelect() {
        return sqlSession.selectList("status.select");
    }
}
