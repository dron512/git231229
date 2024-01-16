package ex11;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03 {

	// 배열을 선언하고
	// 배열을 정렬하고
	// 배열의 모든값을 더해서 출력해보기
	// 메서드를 이용해서
	
	Ex03() {
		int arr[] = new int[] { 10, 20, 5, 2, 11 };
		
		ArrayU myU = new ArrayU();
		myU.sort(arr);
		myU.print(arr);
		
		Scanner scan = new Scanner(System.in);
		scan.next();
	}

	public static void main(String[] args) {
		new Ex03();
	}

}
