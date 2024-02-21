package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();

        list.add(new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }));

        list.add(new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }));
    }
}
