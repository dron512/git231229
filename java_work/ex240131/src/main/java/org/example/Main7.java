package org.example;

import java.math.BigDecimal;

public class Main7 {

    public static void main(String[] args) {
        double a = 1.6;
        double b = 0.1;

        System.out.println(a+b);
        System.out.println(a*b);

        BigDecimal a1 = new BigDecimal(1.6);
        BigDecimal b1 = new BigDecimal(0.1);

        System.out.println(a1.add(b1));
        System.out.println(a1.multiply(b1));

    }
}
