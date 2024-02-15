package org.example;

import java.util.Arrays;
import java.util.List;

public class Main7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "ROBOT", "COMPLEX", "SIMPLE");

        String result = list.parallelStream()
                .reduce("", (s, s2) -> {
                    if (s.length() > s2.length())
                        return s;
                    else
                        return s2;
                });

        System.out.println(result);
    }
}
