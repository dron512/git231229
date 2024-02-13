package org.example;

import java.util.function.Consumer;

public class Main6 {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> {
            String temp = s+s;
            System.out.println(temp);
        };

        consumer.accept("공부");
        consumer.accept("하네요");
        consumer.accept("이걸...");
    }
}
