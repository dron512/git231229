package ex13;

import java.util.Scanner;

class Park {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int answer = 0;
		if (n % 2 == 0) {
			for (int i = 2; i <= n; i += 2) {
				answer += i * i;
			}
		} else {
			for (int j = 1; j <= n; j += 2) {
				answer += j;
			}
		}

		System.out.println(answer);
	}
}