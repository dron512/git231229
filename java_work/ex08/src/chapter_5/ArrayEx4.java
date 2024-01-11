package chapter_5;

import java.util.Arrays;

class ArrayEx4 {
	public static void main(String[] args) {
		
		char[] abc = { 'A', 'B', 'C', 'D' };
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		System.out.println(abc);
		System.out.println(num);

		char[] result = new char[abc.length + num.length];
		
		System.out.println(result.length);
		
		int resultIndex = 2;
		
		result[resultIndex++] = abc[0];
		result[resultIndex++] = abc[1];
		result[resultIndex++] = abc[2];
		result[resultIndex++] = abc[3];
		
		System.out.println(Arrays.toString(result));

		System.arraycopy(num, 0, result, 0, abc.length);
		
		System.out.println(Arrays.toString(result));
		
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(Arrays.toString(result));

		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(Arrays.toString(num));

		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(Arrays.toString(num));
		
	}
}
