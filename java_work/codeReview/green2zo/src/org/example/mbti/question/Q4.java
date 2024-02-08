package org.example.mbti.question;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {

	public void q1() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {

				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Q10. 할 일이 쌓였을 때");
				System.out.println("1번 : 손에 집히는 대로 시작한다.");
				System.out.println("2번 : 우선 계획을 세운다.");
				int num4 = sc.nextInt();
				if (num4 != 1 && num4 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumD(num4);
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

				System.out.println("Q11. 둘 중 더 나은 상황은?");
				System.out.println("1번 : 아무 일정이 없을 때");
				System.out.println("2번 : 모든 일정이 정해져 있을 때");
				int num4 = sc.nextInt();
				if (num4 != 1 && num4 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumD(num4);
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

				System.out.println("Q12. 팀플에서 내가 맡고 싶은 일은?");
				System.out.println("1번 : 정리하고 기록하는 일");
				System.out.println("2번 : 아이디어를 내는 일");
				int num4 = sc.nextInt();
				if (num4 != 1 && num4 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumD(num4);
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
