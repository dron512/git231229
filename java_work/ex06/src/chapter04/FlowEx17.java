package chapter04;

import java.util.*;

class FlowEx17 {
	public static void main(String[] args) {
		int num = 0;

		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();
		num = Integer.parseInt(tmp);

		for (int i = 0; i < num; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
