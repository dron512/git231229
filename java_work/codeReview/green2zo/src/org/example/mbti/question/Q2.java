package org.example.mbti.question;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q2 {
	public void q1() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
				System.out.println("Q4. 선생님이 모르는 걸 알려주실 때 나는");
				System.out.println("1번 : 그러려니 하고 외운다.");
				System.out.println("2번 : 외우기 전에 원리를 이해하고 싶다.");
				int num2 = sc.nextInt();
				if (num2 != 1 && num2 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumB(num2);
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

				System.out.println("Q5. 보조 선생님 학원에서 우리 반 감시하라고 보낸 스파이 아니에요?");
				System.out.println("1번 : 뭐 그런 생각까지 해?");
				System.out.println("2번 : 마음속으로 스파이가 된 자신을 상상해 본다.");
				int num2 = sc.nextInt();
				if (num2 != 1 && num2 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumB(num2);
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
				// 2번 체크
				System.out.println("Q6. 지금부터 아무것도 생각하지 마!");
				System.out.println("1번 : (생각 안 함)");
				System.out.println(
						"2번 : 생각을 안 하는 게 뭐지? 생각을 안 한다고 생각하는 건 생각을\n   하는 건가? 생각을 하지 않는 건가? 아무 생각도 안 하는 게 가능해? ");
				int num2 = sc.nextInt();
				if (num2 != 1 && num2 != 2) {
					throw new IllegalArgumentException("\u001B[31m" + "1 또는 2로 응답해주세요." + "\u001B[0m");
				}

				Sum.sumB(num2);

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
