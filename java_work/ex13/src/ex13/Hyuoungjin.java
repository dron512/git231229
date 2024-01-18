package ex13;

import java.util.Scanner;

public class Hyuoungjin {

	public static void main(String[] args) {
		start();
	}

	public static void start() {
		Scanner sc = new Scanner(System.in);
		String str;
		boolean sw = true;

		System.out.println("선택");
		System.out.println("1.구구단");
		System.out.println("2.종료");

		str = sc.nextLine();

		while (sw) {

			switch (str) {
			case "1":
				System.out.println("단 입력");
				int dan = Integer.parseInt(sc.nextLine());
				if (0 < dan && dan < 10) {
					for (int i = 1; i < 10; i++) {
						System.out.println(dan + " * " + i + " = " + dan * i);
					}
				}

				System.out.println("다시하시겠습니까?");
				System.out.println("1.네");
				System.out.println("2.종료");

				String re = sc.nextLine();

				if (re.equals("1")) {
					continue;
				} else if (re.equals("2")) {
					sw = false;
				}

				break;
			case "2":
				sw = false;
				break;

			default:
				System.out.println("다시 입력 해주세요");
				System.out.println("1.구구단");
				System.out.println("2.종료");

				str = sc.nextLine();

				continue;
			}
		}

		System.out.println("종료됐습니다");

	}

}
