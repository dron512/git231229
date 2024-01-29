package com.example.mateproject.dao;

import com.example.mateproject.dto.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession sqlSession;

    //    public List<Member> doSelectByMemId() {
//        return sqlSession.selectList("member.selectByMemId");
//    }

    public List<Member> doSelect() {
        return sqlSession.selectList("member.select");
    }

    public void doInsert(Member member) {
        sqlSession.insert("member.insert", member);
    }

    public void doPInsert(Member member) {
        sqlSession.insert("member.pinsert", member);
    }

    public Member doSelectRow(Member member) {
        return sqlSession.selectOne("member.selectrow", member);
    }

    public void doDelete(Member member) {
        sqlSession.delete("member.delete", member);

    }


}
