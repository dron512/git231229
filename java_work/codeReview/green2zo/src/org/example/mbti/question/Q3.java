package org.example.mbti.question;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3 {

	public void q1() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Q7. 약속 시간에 1시간이나 늦은 친구,");
				System.out.println("1번 : 사과 이전에 늦은 이유가 궁금하다.");
				System.out.println("2번 : 친구의 진심을 담은 사과에 마음이 풀린다.");
				int num3 = sc.nextInt();
				if (num3 != 1 && num3 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumC(num3);
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

				System.out.println("Q8. 나는 대화를 할 때");
				System.out.println("1번 : 사람보다 챗지피티와 대화하는 게 편하다.");
				System.out.println("2번 : 당연히 사람이 더 편하다.");
				int num3 = sc.nextInt();
				if (num3 != 1 && num3 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumC(num3);
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

				System.out.println("Q9. 더 기분 좋은 칭찬은?");
				System.out.println("1번 : 너 천재임?");
				System.out.println("2번 : 너 천사임?");
				int num3 = sc.nextInt();
				if (num3 != 1 && num3 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumC(num3);
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
