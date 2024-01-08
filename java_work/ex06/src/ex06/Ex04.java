package ex06;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("시간 입력");
		int hour = scan.nextInt();
		int min = scan.nextInt();
		
		System.out.println(hour);
		System.out.println(min);
		
		// 10시 10분
		// 만약에 분이 45분보다 작으면 시간을 1빼야한다
		
		// 10분 - 45분
		// 45이상이면 분은 그냥 뺴면 되고..
		// 아니면...
		// 60분을 더해서 - 45를 빼야한다..;
		// hour == 0 일때는 24로 바꾸기
		
		if (hour ==0)
			hour = 24;
		
		if( min < 45) {
			hour = hour-1;
			min = (min+60)-45;
		}
		else {
			min = min - 45;
		}
		
		System.out.println(hour);
		System.out.println(min);
		
	}
}









