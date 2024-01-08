package chapter04;
import java.util.*;

class FlowEx6 {
	public static void main(String[] args) { 
		int month = 0;
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); 
		month = Integer.parseInt(tmp);   

		switch(month) {
			case 3:
				System.out.println("3입니다");
				break;
			case 4: 
				System.out.println("4입니다");
				break;
			case 5:
				System.out.println("5입니다");
				break;
			case 6: case 7: case 8:
				System.out.println("6,7,8입니다");
				break;
			case 9: case 10: case 11:
				System.out.println("9,10,11입니다");
				break;
			default:
				System.out.println("default");
		}
		System.out.println("종료됩니다.");
	}
}
