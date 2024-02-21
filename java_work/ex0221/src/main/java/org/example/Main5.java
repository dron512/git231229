package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main5 {

    public static void main(String[] args) {

        Runnable run1 = () -> {
//            for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "ㅋㅋㅋ A 쓰레드 ");
//            }
        };

        Runnable run2 = () -> {
//            for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "ㅋㅋㅋ B쓰레드 ");
//            }
        };

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(run1);
        es.submit(run2);
        es.submit(() -> {
//            for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "ㅋㅋㅋ C쓰레드 ");
//            }
        });

        es.shutdown();
    }

}
