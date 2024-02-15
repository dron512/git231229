package org.example;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main10 {

    public static void main(String[] args) {

        System.out.println(
                IntStream.of(1, 3, 5, 7, 9)
                        .sum()
        );

        System.out.println(
                IntStream.of(1, 3, 5, 7, 9)
                        .count()
        );

        IntStream.of(1, 3, 5, 7, 9)
                .average().ifPresent(System.out::println);

        IntStream.of(1, 3, 5, 7, 9)
                .max().ifPresent(System.out::println);

        IntStream.of(1, 3, 5, 7, 9)
                .min().ifPresent(System.out::println);

        double avg = IntStream.of()
                        .average().orElse(10);
        System.out.println(avg);
        Person p = getPerson().orElse(new Person("홍길동",20));
        System.out.println(p);

    }

    public static Optional<Person> getPerson(){
        return Optional.empty();
    }

}
