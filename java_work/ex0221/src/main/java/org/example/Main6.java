package org.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main6 {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        Callable<Double> task = ()->{
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum+=i;
            }
            return Double.valueOf(sum+"");
        };

        ExecutorService es = Executors.newSingleThreadExecutor();
        double sum = es.submit(task).get();
        System.out.println(sum);
        es.shutdown();
    }
}
