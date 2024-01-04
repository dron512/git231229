package ex02;

import java.util.Scanner;

/*
 * 숫자 두개를 입력받아 더한 값 출력 해주세요
 * 
 * scanner 안에 있는 함수
 * nextLine 문자열 입력받는다.
 * nextInt 숫자를 입력받는다.
 * 
 * 백앤드
 * java - jsp - spring - springboot 
 * 
 * 
 * 5개월
 * 리눅스
 * 웹크롤링(html + css)
 * 머신러닝 딥러닝
 * 통계 수학공부
 * java + python
 * sql
 * 
 */

public class Ex08 {
	
	// num1 과 num2 매개변수로 받고 int형을 돌려주는 solution 함수
	public static int solution(int num1, int num2) {
		num1 = 10;
		System.out.println(num1);
		return num1 + num2;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int num1 = scan.nextInt();
		
		System.out.println("숫자 입력");
		int num2 = scan.nextInt();
		
		int result = solution(num1, num2);
		
		System.out.println("결과 = "+ result);
		System.out.println("num1 = "+ num1);
		
		int result1 = solution(num1, num2);
		
		System.out.println("결과 = "+ result1);
		
	}
	
}







