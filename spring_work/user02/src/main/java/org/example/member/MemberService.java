package org.example.member;

// alt + 1 project
// alt + insert 새로생성

// esc 소스로 이동

import org.example.component.AABBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

// 파일간 이동  ctrl+tab
// shift shift
@Service
public class MemberService {

    @Autowired
    @Qualifier("AABBService")
    AABBService aabbService;

    @Autowired
    MemberDAO memberDAO;

    // Member Map 등록하러.. 가야함...
    public void Regist(Member member){
        memberDAO.insert(member);
    }

    // 내용을 출력
    public void list(){
        Collection<Member> collection = memberDAO.select();
        collection.forEach(System.out::println);
    }

}
