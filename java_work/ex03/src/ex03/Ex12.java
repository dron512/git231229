package ex03;

import java.util.Scanner;

/*
 * 실수는 소수 두번쨰 
 * 
 * 숫자를 입력받아 소수 둘째짜리까지만 보여주세요...
 * 
 * ex)
 * 23.456
 * 23.45
 * 
 * ex)
 * 11.1356712
 * 11.13
 */
public class Ex12 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("숫자 입력");
		
		// next() 문자열입력... 빈공백전까지...
		// nextLine() 문자열 한줄..
		// nextInt() 정수 입력
		// nextDouble() 실수 입력...
		double d = scan.nextDouble();

		System.out.println("d = "+ d);
		
		// 45.123123123*100
		// 4512.123123 -> int
		// 4512 / 100.0 -> double 
		// 45.12
//		double trans_d = (int)(d*100)/100.0;
//		System.out.println("trans_d = "+trans_d);
		
		System.out.println("trans_d = "+(int)(d*100)/100.0);
	}
}















