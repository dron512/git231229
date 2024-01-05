package ex05;

import java.util.Scanner;

// ctrl + 1 빠른 에러처리
// f2 파일 이름 변경
public class Solution {
	public static String solution(String my_string, int k) {
		String result = "";
		// i=0 부터 9까지 동작해라...
		
		// ㄱ + 10 ???? ㄱ10
		// abc + abc = abcabc
		// ""+ abcde =   result = abcde
		// abcde + abcde = result = abcdeabcde
		// abcdeabcde + abcde = abcdeabcd
		
		for (int i = 0; i < k; i++) {
			result = result + my_string;
		}
		return result;
	}

	public static void main(String[] args) {
		String my_string = "abcde";
		int num = 10;

		String temp = solution(my_string, num);
		System.out.println(temp);

	}
}