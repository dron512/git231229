package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main3 {

    public static void main(String[] args) {
        String[] str = {"홍길동", "김길동", "박길동"};

        Stream<String> stream = Arrays.stream(str);
        Arrays.stream(str).forEach(s -> System.out.println(s));

        System.out.println();
        Arrays.stream(str).forEach(System.out::println);

        System.out.println();
        for ( String temp : str){
            System.out.println(temp);
        }

    }
}
