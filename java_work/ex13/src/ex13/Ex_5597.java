package ex13;

/* 백준 5597번
   10명의 학생중 두명이 과제 제출을 안했는데
   제출 안한 두명의 출석 번호를 출력
   과제 제출한 번호 3 1 4 5 7 9 6 10
*/
import java.util.Scanner;

public class Ex_5597 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[] arr = new int[11];

		int a;

		for (int i = 1; i < 9; i++) {
			a = scan.nextInt();
			arr[a] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != 1) {
				System.out.println(i);
			}
		}
		
		scan.close();
	}
}
