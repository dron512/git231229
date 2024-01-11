package chapter_5;

import java.util.*;

class ArrayEx9 {
	public static void main(String[] args) {
		
		// 배열의 요소, element
		int[] code = { -4, -1, 3, 6, 11 };
		int[] arr = new int[30];

		// i=0부터 9까지 동작을 합니다...
		for (int i = 0; i < arr.length; i++) {
			// 0 < x < 1
			// 0 < x < 5
			// x = 0.00000000001 x= 4.99999999
			// 0, 1,2,3, 4
			int tmp = (int) (Math.random() * code.length);
			arr[i] = code[tmp];
		}

		System.out.println(Arrays.toString(arr));
		
	} 
}
