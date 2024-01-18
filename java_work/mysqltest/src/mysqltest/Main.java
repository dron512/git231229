package mysqltest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		
		if(input.equals("할일입력")) {
			System.out.println("DB에 할일입력넣기");
		}
		else if(input.equals("할일목록")) {
			System.out.println("DB에 할일목록 보여주기");
		}
		
	}
}
