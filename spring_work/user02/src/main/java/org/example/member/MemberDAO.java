package org.example.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    private Map<String,Member> map = new HashMap<>();
    private static Long id = 0L;

    public void insert(Member member) {
        member.setId(++id);
        map.put(member.getEmail(),member);
    }

    public Collection<Member> select() {
        return map.values();
    }
}
