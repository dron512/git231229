package org.example;

import java.util.function.Function;

public class Main4 {

    public static void main(String[] args) {
//        Function<char[],String> fn = chars -> {
//          return new String(chars);
//        };

        Function<char[],String> fn = chars -> new String(chars);
        Function<char[],String> fn1 = String::new;

        String str = fn.apply(new char[]{'R','O','B','O','T'});
        System.out.println(str);

        String str1 = fn1.apply(new char[]{'B','A','N','A','N','A'});
        System.out.println(str1);

    }
}
