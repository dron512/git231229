package chapter_5;

import java.util.*;

class ArrayEx2 {
	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
//		int[] iArr3 = new int[]{100, 95, 80, 70, 60};
		int[] iArr3 = { 100, 95, 80, 70, 60 };
		char[] chArr = { 'a', 'b', 'c', 'd' };

		// i=0부터 9까지 진행..
		// i= 0,1,2,3,4,5,6,7,8,9 // 백견이불여일타
		 iArr1[0] = 1; iArr1[1] = 2; iArr1[2] = 3; iArr1[3] = 4; iArr1[4] = 5;
		 iArr1[5] = 6; iArr1[6] = 7; iArr1[7] = 8; iArr1[8] = 9; iArr1[9] = 10;
		 
		for (int i = 0; i < iArr2.length; i++) {
			iArr2[i] = (int) (Math.random() * 10) + 1;
		}
		// 배열이 값 출력하는 방법
		for (int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i] + ",");
		}
		System.out.println();
		
		for (int i = 0; i < iArr2.length; i++) {
			System.out.print(iArr2[i] + ",");
		}
		// 배열을 문자로 출력하기...
		String a = "[abcdef]";
		a = a.replace("[", ""); a = a.replace("]", "");
		System.out.println("\n\n"+a+"\n\n");
		
		// 8버전...
		String b = Arrays.toString(iArr1);
		b = b.replace("[", "");
		b = b.replace("]", "");
		
		System.out.println(b);
		
		System.out.println();
		System.out.println(Arrays.toString(iArr2));
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));
		System.out.println(iArr3);
		System.out.println(chArr);
	}
}
