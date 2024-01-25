package main;

import java.util.Scanner;

public class Boseong {
    public static void main(String[] args) {

        // 백준 2884번 알람시계
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); // h는 시간
        int m = sc.nextInt(); // m은 분

        // 입력된 시간에 60을 곱해 분으로 변환 // 그후 분을 더하고 45를 뺀다
        // 이후 분을 시로 변환해주고 남는걸 분으로 지정해주면 된다
        int totalMinutes = (h * 60) + m - 45;

        // 만약에 음수인 경우 //  24시간을 더해준다
        if (totalMinutes < 0) {
            totalMinutes += 24 * 60; // 현재까지 분 단위이기 떄문에 24시간을 60으로 곱한걸 더함 // 1440분을 더한다
        }

        // 시간과 분 계산 // 시간은 60으로 나누고 24로 나눈 나머지 // 분은 60으로 나눈 나머지
        h = totalMinutes / 60 % 24;
        m = totalMinutes % 60;

        System.out.println(h + "시 " + m + "분");
    }
}