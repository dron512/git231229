package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main8 {

    public static void main(String[] args) {
        Stream.of(11, 22, 33, 44, 55)
                .forEach(System.out::println);

        System.out.println();
        Stream.of("So Simple")
                .forEach(System.out::println);

        System.out.println();
        Stream.of(Arrays.asList("11", "aaa", "bbb"), Arrays.asList("test"))
                .forEach(System.out::println);

        System.out.println();
        IntStream.range(1,10).forEach(System.out::println);
        System.out.println();
        IntStream.rangeClosed(1,10).forEach(System.out::println);

        System.out.println();
        System.out.println(  IntStream.range(1,10).filter(value -> value%2==1).sum() );
        System.out.println();
        System.out.println( IntStream.rangeClosed(1,10).sum() );
    }

}
