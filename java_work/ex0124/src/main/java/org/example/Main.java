package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 자식객체는 부모객체를 담을수있다.
        // 부모객체는 자식객체를 참조할수 있다.
        Friend[] f = new Friend[5];

        f[0] = new UniFriend("hongildong","computer","01099262662");
        f[1] = new CompFriend("compgildong","aa","0101234-1234");

//        System.out.println(f[0]);
//        System.out.println(f[1]);
        System.out.println(Arrays.toString(f));

        List<Friend> list = new ArrayList<>();
        list.add(new UniFriend("hongildong","computer","01099262662"));
        list.add(new CompFriend("hongildong","aa","0101234-1234"));

        System.out.println(list);

    }
}
