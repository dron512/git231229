package org.example.member;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    private static long id = 0;
    private Map<String,Member> map =
            new HashMap<>();

    public void insert(Member member) {
        member.setId(++id);
        map.put(member.getEmail(), member);
    }

    public Collection<Member> select(){
        return map.values();
    }


}
