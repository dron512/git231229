package ex06;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		
		System.out.println(temp.charAt(0));
		System.out.println(temp.charAt(1));
		System.out.println(temp.charAt(2));
		
		String[] ar = { "ㄱ", "ㄴ", "ㄷ", "ㄹ"};
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		
		String c = "10 20 30 40";
		System.out.println(c.split(" ")[0]);
		String temp1 = c.split(" ")[1];
//		String test[] = c.split(" ");
//		System.out.println(test[0]);
//		System.out.println(test[1]);
//		System.out.println(test[2]);
//		System.out.println(test[3]);
		
		
	}
}
