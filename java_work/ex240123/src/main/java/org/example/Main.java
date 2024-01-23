package org.example;

/*
    alt+1 <-왼쪽화면
    esc -> 소스로
    ctrl + tab 소스창 이동
    shift 두번 눌러요... 파일명을검색하시면
 */

import org.example.myclass.Member;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        Member[] members = new Member[100];

        List<Member> list = new ArrayList<>();

        Member member1 = new Member("홍길동",20);
        System.out.println(member1);

        Member member2 = new Member("박길동",20);
        System.out.println(member2);

//        members[0] = member1;
//        members[1] = member2;

        list.add(member1);
        list.add(member2);

        System.out.println(list);

        Member md1 = list.get(0);
        System.out.println(md1);

    }
}