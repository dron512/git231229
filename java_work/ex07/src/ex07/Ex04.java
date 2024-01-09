package ex07;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int rowNum = scan.nextInt();
		
		// 5
		// 첫번째줄에서는 1번반복
		// 두번쨰줄에서는 2번반복
		// 세번쨰줄에서는 3번반복
		// 네번째줄에서는 4번반복
		// 다섯번쨰줄에서는 5번 반복
		// 0 1 2 3 4
		for (int i =0; i<rowNum ;i++) {
			// i+1 = 1
			// i+2 = 2
			// i+3 = 3
//			System.out.print("i = "+i+"\t");
			for(int j=0; j< i+1 ;j++) {
//				System.out.print(" j = "+j);
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
	}
}
