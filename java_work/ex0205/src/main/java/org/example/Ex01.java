package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 문자열을 정렬할 수 있는 LIST를 만들어보자.

public class Ex01 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("ROBOT","TOY","BOX","WEAPON");
        list = new ArrayList<>(list);

// Arrays.sort();
// Arrays.sort(list);
        
        Collections.sort(list);
        System.out.println(list);

    }
}
