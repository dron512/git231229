package chapter04;

import java.util.*;

class FlowEx2 {
	public static void main(String[] args) {
		int input;

		Scanner scanner = new Scanner(System.in);
		input = Integer.parseInt(scanner.nextLine());

		if (input == 0) {
			System.out.println("0을 입력했네요.");
		}

		if (input != 0)
			System.out.println("0말고 다른것을 입력했네요" + input);
	}

}
