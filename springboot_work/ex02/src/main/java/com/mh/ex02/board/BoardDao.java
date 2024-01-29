package com.mh.ex02.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BoardDao {

    @Autowired
    SqlSession sqlSession;

    public List<BoardDto> getAll(){
        List<BoardDto> list  = sqlSession.selectList("board.selectAll");
//        List<BoardDto> list = Arrays.asList(
//                BoardDto.builder().name("홍길동").build(),
//                BoardDto.builder().name("이길동").build(),
//                BoardDto.builder().name("박길동").build()
//            );
        return list;
    }

}
