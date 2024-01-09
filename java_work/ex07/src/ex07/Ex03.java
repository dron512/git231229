package ex07;

import java.util.Scanner;

public class Ex03 {
	/*
	 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 <
	 * A, B < 10) 입력의 마지막에는 0 두 개가 들어온다.
	 * String[] stra = "10 20 30";
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		for (int i = 0;; i++) {
			String temp = scan.nextLine();
			
			if (temp.equals("0 0")) {
//				System.out.println("종료됩니다.");
				break;
			}
			
			int num1 = Integer.parseInt(temp.split(" ")[0]);
			int num2 = Integer.parseInt(temp.split(" ")[1]);
			
//			System.out.println("num1 = " + num1);
//			System.out.println("num2 = " + num2);

			System.out.println(num1+num2);
			
//			System.out.println(temp);
		}
	}
}
