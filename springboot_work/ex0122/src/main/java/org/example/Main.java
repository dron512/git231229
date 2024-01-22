package org.example;

public class Main {

    public static void main(String[] args) {
    // alt + 1 -> alt + insert
        System.out.println("Hello world!");

        AA.doB();
//        AA.doA();
        AA a1 = new AA();
        a1.doA();
        System.out.println(a1.getA());

    }

}