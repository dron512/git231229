package org.example;

import java.util.*;

class StrComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

public class Main4 {
    public static void main(String[] args) {
        // 불변객체...
        List<String> list = Arrays.asList("aa", "b", "ccc", "dddd", "");
        // 변할수 객체..
        list = new ArrayList<>(list);

        /*
        StrComp comp = new StrComp();
        // 정렬...
        Collections.sort(list, comp);
         */

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

//        Collections.sort(list, comp);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Collections.sort(list, (o1, o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}











