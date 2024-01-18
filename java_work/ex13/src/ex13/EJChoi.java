package ex13;

import java.util.Scanner;

public class EJChoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++) {
				System.out.print("!");
			}
			for (int k = 0; k <= i * 2; k++) {
				System.out.print("*");
			}

			System.out.println();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < (n - i - 1) * 2; k++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}
}
