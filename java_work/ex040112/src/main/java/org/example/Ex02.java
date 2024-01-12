package org.example;

import java.util.Scanner;

public class Ex02 {

    // 1.변수 2.연산자 3.제어문 4.배열

    // 문제 풀면서.. 기억나는거 찾아보면 됩니다..

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer = "";
        System.out.println("문자열 입력");
        String str = scan.next();
        System.out.println("숫자 입력");
        int n = scan.nextInt();

        System.out.println(str);
        System.out.println(n);

        // i = 0,1,2,3,4 일때 동작하게 된다....5번..반복
        for (int i = 0; i < 5; i++) {
            answer = answer + str;
        }
        System.out.println(answer);
    }
}
