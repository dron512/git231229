package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main8 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        String result = now.format(DateTimeFormatter.ofPattern("YYYY-MM-DD HH:mm"));
        System.out.println(result);

        result = now.format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
        System.out.println(result);

    }
}
