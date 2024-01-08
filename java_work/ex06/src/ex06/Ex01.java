package ex06;

import java.util.Scanner;

/*
연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.

12 ⊕ 3 = 123
3 ⊕ 12 = 312

양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
 */
public class Ex01 {
	/*
	 * int -> double
	 * double -> int
	 * 
	 * String -> int
	 * Integer.parseInt(변수명);
	 * 
	 * String -> double
	 * Double.parseDoube(변수명);
	 * 
	 * String -> float
	 * Float.parseFloat(변수명);
	 * 
	 * 10+20 = 30
	 * "10"+20 = 1020
	 * 3+""+1 = 31
	 */
	public static int solution(int a, int b) {
		int result1 = Integer.parseInt(a+""+b);
		int result2 = Integer.parseInt(b+""+a);
		
		if(result1<result2)
			return result2;
		else
			return result1;
	}

	public static void main(String[] args) {
		String ac="100";
		Integer.parseInt(ac);
		int a = 12;
		int b = 3;
		
		int result = solution(a,b);
		System.out.println(result);
	}

}
