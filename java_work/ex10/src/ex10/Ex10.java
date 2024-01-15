package ex10;

import java.util.Scanner;

public class Ex10 {

	public int solution(int num1, int num2, String yon) {
		int result = 0;

		if (yon.equals("+"))
			result = num1 + num2;
		else if (yon.equals("-"))
			result = num1 - num2;
		else if (yon.equals("*"))
			result = num1 * num2;
		else if (yon.equals("/"))
			result = num1 / num2;

		System.out.println(result);

		return result;
	}

	Ex10() {
		Scanner scan = new Scanner(System.in);

		System.out.println("첫번째 수 입력: ");
		int num1 = scan.nextInt();
		System.out.println("두번째 수 입력: ");
		int num2 = scan.nextInt();
		System.out.println("연산자 입력: ");
		String yon = scan.next();

		System.out.println("num1 = " + num1 + " num2 = " + num2 + " yon = " + yon);
		
		solution(num1, num2, yon);
	}

	public static void main(String[] args) {
		new Ex10();
	}
}
