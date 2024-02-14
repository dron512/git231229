package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,5,7,9);

        list.forEach( integer -> System.out.println(integer) );
        System.out.println();
        list.forEach( System.out::println );

//        list = new ArrayList<>(list);
    }
}
