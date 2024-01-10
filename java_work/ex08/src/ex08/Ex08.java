package ex08;

import java.util.Arrays;

public class Ex08 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] brr = Arrays.copyOf(arr, 10);
//		int[] brr = new int[arr.length];
//
//		for(int i =0; i<arr.length;i++) {
//			brr[i] = arr[i];
//		}
//		
		arr[0] = 100;

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(brr));
	}
}
