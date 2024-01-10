package chapter_5;

import java.util.Arrays;

class ArrayEx3 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		
		// for 구문으로 arr 입력
		for (int i = 0; i < arr.length; i++)
			arr[i] = i + 1;

		// for 구문으로 arr 출력
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr[" + i + "]:" + arr[i]);

		// tmp 배열 선언... 5*2 길이 10
		// tmp 값 넣기 전에는 배열은 모든 값을 0 으로 선언해서 진행한다.
		// 자바에서는 배열선언과 동시에 모든값을 0으로 초기화합니다
		int[] tmp = new int[arr.length * 2];
		System.out.println(Arrays.toString(tmp));

		// 입력
		for (int i = 0; i < arr.length; i++)
			tmp[i] = arr[i];
		
		System.out.println(Arrays.toString(tmp));
		
		arr = tmp; 

		System.out.println("������ - arr.length:" + arr.length);
		for (int i = 0; i < arr.length; i++)
			System.out.println("arr[" + i + "]:" + arr[i]);
	}
}
