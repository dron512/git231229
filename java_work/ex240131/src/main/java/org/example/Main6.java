package org.example;

public class Main6 {

    public static void main(String[] args) {
        double a = 0.99999999;
        double b = 0.00000001;

        System.out.println(a + b);

        double c = 0.001;

        for (int i = 0; i < 1000; i++) {
            c = c + c;
        }

        System.out.println(c);
    }
}
