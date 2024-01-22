package mysqltest;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		DB db = new DB();
		db.
		
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1. 할일입력");
			System.out.println("2. 할일목록");
			System.out.println("3. 종료");
			System.out.println("번호 입력하세요");
			
			String input = scan.nextLine();
			
			if(input.equals("1")) {
				System.out.println("뭐할래?");
				String todo = scan.nextLine();
				db.insert(todo);
			}
			else if(input.equals("2")) {
				db.select();
			}
			else {
				System.out.println("종료합니다.");
				break;
			}
		}
		
	}
}
