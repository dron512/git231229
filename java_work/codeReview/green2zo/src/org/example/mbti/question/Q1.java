package org.example.mbti.question;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Q1 {

	public void q1() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Q1. 나는 사실");
				System.out.println("1번 : 백엔드보다 프론트엔드가 좋다.");
				System.out.println("2번 : 백엔드가 잘 맞는다.");

				int num1 = sc.nextInt();

				if (num1 != 1 && num1 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumA(num1);
				break;
			} catch (InputMismatchException e) {

				System.err.println("1 또는 2로 응답해주세요.");

				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

	public void q2() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("Q2. 나는 사실");
				System.out.println("1번 : 조원보다 조장이 되고 싶었다.");
				System.out.println("2번 : 조원으로 만족한다.");
				int num1 = sc.nextInt();
				if (num1 != 1 && num1 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumA(num1);
				break;
			} catch (InputMismatchException e) {

				System.err.println("1 또는 2로 응답해주세요.");

				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

	public void q3() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("Q3.나는 관종이다.");
				System.out.println("1번 : 그렇다.");
				System.out.println("2번 : 아니다.");

				int num1 = sc.nextInt();
				if (num1 != 1 && num1 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumA(num1);

				break;
			} catch (InputMismatchException e) {

				System.err.println("1 또는 2로 응답해주세요.");

				sc.nextLine();
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}