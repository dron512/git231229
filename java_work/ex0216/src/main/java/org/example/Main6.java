package org.example;

import java.time.ZoneId;

public class Main6 {

    public static void main(String[] args) {

//        ZoneId.getAvailableZoneIds()
//                .stream()
//                .sorted()
//                .forEach(System.out::println);

        System.out.println();

        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Asia"))
                .sorted()
                .forEach(System.out::println);

    }
}
