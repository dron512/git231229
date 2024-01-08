package chapter04;
import java.util.*;

class FlowEx8 {
	public static void main(String[] args) { 
		char gender = 0;
		String regNo = "";
		
		Scanner scanner = new Scanner(System.in);
		regNo = scanner.nextLine();

		gender = regNo.charAt(7); 

		switch(gender) {
			case '1':
//				System.out.println("1번은 2000년생 이하의 남자입니다.");
			case '3':
				System.out.println("남자입니다");
				break;
			case '2':
//				System.out.println("22222");
			case '4':
				System.out.println("여자입니다");
				break;
			default:
				System.out.println("아닐때 일로 온다..");
		}
	} 
}
