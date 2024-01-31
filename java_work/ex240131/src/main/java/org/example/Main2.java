package org.example;

public class Main2 {

    public static void main(String[] args) {

        INum iNum1 = new INum(10);
        INum iNum2 = new INum(10);
        INum iNum3 = new INum(13);

        System.out.println(iNum1);
        System.out.println(iNum2);
        System.out.println(iNum3);

        System.out.println(iNum1 == iNum2);
        System.out.println(iNum1.equals(iNum2));

    }
}
