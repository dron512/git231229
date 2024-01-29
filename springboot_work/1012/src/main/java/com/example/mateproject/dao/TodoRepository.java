package com.example.mateproject.dao;

import com.example.mateproject.dto.Todolist;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    SqlSession sqlSession;

    public List<Todolist> doSelect() {
        return sqlSession.selectList("todo.select");
    }

    public void doInsert(Todolist todolist) {
        sqlSession.insert("todo.insert", todolist);
    }

    public void doPInsert(Todolist todolist) {
        sqlSession.insert("todo.pinsert", todolist);
    }

    public Todolist doSelectRow(Todolist todolist) {
        return sqlSession.selectOne("todo.selectrow", todolist);
    }

    public void doDelete(Todolist todolist) {
        sqlSession.delete("todo.delete", todolist);

    }

    public Todolist selectrow(int id) {
        return sqlSession.selectOne("todo.selectrow", id);
    }

    public void doUpdate(Todolist existingTodo) {
        sqlSession.update("todo.update", existingTodo);
    }
}

