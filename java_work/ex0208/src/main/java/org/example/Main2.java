package org.example;

interface Calcu {
    void cal(int a, int b);
}

interface RetCalcu {
    int cal(int a, int b);
}

public class Main2 {

    public static void doA(Calcu cc, int... a) {
        cc.cal(a[0], a[1]);
    }

    // ctrl + alt + l
    public static void main(String[] args) {
        RetCalcu rcc = (a, b) -> a + b;

        int result = rcc.cal(5, 5);
        System.out.println(result);

        System.out.println(rcc.cal(5, 5));

        doA((a, b) -> System.out.println(a + b), 10, 20, 30);
        doA((a, b) -> System.out.println(a - b), 10, 20);

        /*
        Calcu cc1 = (a, b) -> System.out.println(a + b);
        cc1.cal(10, 20);

        Calcu cc2 = (a, b) -> System.out.println(a - b);
        cc2.cal(10, 20);
        */

    }
}
