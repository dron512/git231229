package main;

import java.util.Arrays;
import java.util.Scanner;

public class Show {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("점의 갯수");
		int N = scan.nextInt(); /// 좌ㅍ표상에 점의 갯수

		int[] a = new int[N];
		int[] b = new int[N];

		System.out.println("점의 위치");
		for (int i = 0; i < N; i++) {
			int X = scan.nextInt();
			a[i] = X; // X축 좌표들

			int Y = scan.nextInt();
			b[i] = Y;// Y축 좌표들
		}
		
		Arrays.sort(a);
		System.out.println("X축의 위치 " +Arrays.toString(a));
		// X 축 배열 오름차순으로 정렬
		Arrays.sort(b);
		System.out.println("Y축의 위치 " +Arrays.toString(b));
		// Y 축 배열 오름차순으로 정렬

		int c = a[a.length - 1] - a[0];
		System.out.println("사각형의 X축의 길이 = " + c);
		// 사각형 X축의 길이
		int d = b[b.length - 1] - b[0];
		System.out.println("사각형의 Y축의 길이 = " + d);
		// 사각형 Y축의 길이

		System.out.println("사각형의 크기 = " + (c * d));
		
	}
}
