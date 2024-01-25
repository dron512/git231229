package etc;

import java.util.Arrays;
import java.util.Scanner;

public class Chanwoo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("단어를 입력해주세요 : ");
		String string = sc.next();

		// 문자열을 배열로 변경한뒤 역순으로 만들기
		char word[] = string.toCharArray();
		char palindrome[] = new char[string.length()];
		for (int i = 0; i < word.length; i++) {
			palindrome[i] = word[word.length - i - 1];
		}
		if (Arrays.equals(word, palindrome)) {
			System.out.println(palindrome);
			System.out.println("palindrome 단어입니다");
		} else {
			System.out.println(palindrome);
			System.out.println("palindrom 단어가 아닙니다");
		}

		
		
		// reverse를 써서 역순으로 만들기
//		StringBuilder st = new StringBuilder(string);
//		String palindrome = st.reverse().toString();
//		System.out.println(palindrome);
//
//		if (Arrays.equals(word, palindrome)) {
//			System.out.println(palindrome);
//			System.out.println("palindrome 단어입니다");
//		} else {
//			System.out.println(palindrome);
//			System.out.println("palindrom 단어가 아닙니다");
//		}
	}
}
