package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main4 {

    public static void main(String[] args) {

        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(  ()->{
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName()+" "+(n1+n2));
        }  );
        es.submit(  ()->{
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName()+" "+(n1+n2));
        }  );
        es.submit(  ()->{
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName()+" "+(n1+n2));
        }  );

        System.out.println("main Thread 종료");
        es.shutdown();

    }
}
