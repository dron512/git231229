package org.example;

public class Main5 {

    public static void main(String[] args) {

        // boxing
        Integer integer1 = Integer.valueOf(10);
        Integer integer2 = Integer.valueOf(20);

        // unboxing
        int int1 = integer1;
        int int2 = integer2.intValue();

        System.out.println(integer1);
        System.out.println(integer2);

        System.out.println(int1);
        System.out.println(int2);

        System.out.println();

        System.out.println(Integer.max(10,20));
        System.out.println(Integer.min(10,20));
        System.out.println(Integer.sum(10,20));

    }

}
