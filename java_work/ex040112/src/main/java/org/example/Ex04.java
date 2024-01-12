package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int student_num[] = new int[28];

        for (int i = 0; i < student_num.length; i++) {
            int num = sc.nextInt(); // 28개의 숫자 입력
            student_num[i] = num;
        }

        Arrays.sort(student_num); // 올림차순으로 정렬
        System.out.println(Arrays.toString(student_num));
        for (int i = 1; i < student_num.length; i++) {
            for (int j = 1; j < student_num[i] - student_num[i - 1]; j++) { // j는 뒷숫자 - 앞숫자 까지
                if (student_num[i] - student_num[i - 1] > 2) // 뒷숫자 - 앞숫자가 2보다 클때
                    System.out.println(student_num[i - 1] + j);
                else if (student_num[i] - student_num[i - 1] == 2) // 뒷숫자 - 앞숫자가 2일때
                    System.out.println(student_num[i] - 1);
            }
        }
    }
}
