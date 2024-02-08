package org.example.mbti.question;


public class Sum {

    public static int sum1 = 0;
    public static int sum2 = 0;
    public static int sum3 = 0;
    public static int sum4 = 0;

    public static int sumA(int suma) {

        if (suma == 1) {

            return sum1;
        } else {
            sum1++;
        }
        return sum1;
    }

    public static int sumB (int suma){
        if (suma == 1) {

            return sum2;
        } else {
            sum2++;
        }
        return sum2;
    }

    public static int sumC(int suma){
        if (suma == 1 ) {

            return sum3;
        } else {
            sum3++;
        }
        return sum3;
    }

    public static int sumD(int suma){
        if (suma == 1 ) {

            return sum4;
        } else {
            sum4++;
        }
        return sum4;
    }
}