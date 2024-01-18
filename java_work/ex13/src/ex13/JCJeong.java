package ex13;

import java.util.Scanner;

public class JCJeong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문자열 입력 후 엔터를 누르세요. 엔터 두 번 누르면 입력된 문자열을 이어붙여 출력됩니다.");

        StringBuilder result = new StringBuilder();
        String input;

        while (true) {
            input = sc.nextLine();

            if (input.isEmpty()) {
                break;
            }

            result.append(input);
        }

        System.out.println("결과: " + result.toString());
    }
}
