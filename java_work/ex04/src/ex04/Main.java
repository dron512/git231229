package ex04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = scan.nextLine();
		String [] numbers = str.split(" ");
		long A = Long.parseLong(numbers[0]);
		long B = Long.parseLong(numbers[1]);
		long C = Long.parseLong(numbers[2]);
		
		System.out.println(A+B+C);
		
	}
}
