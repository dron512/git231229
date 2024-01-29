package com.example.mateproject.proc_test.repository;

import com.example.mateproject.proc_test.dto.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    SqlSession sqlSession;

    public List<Student> doSelect(){
        return sqlSession.selectList("student.select");
    }

}
