package ex09;

import java.util.Arrays;

public class Ex06 {

	// 랜덤한 숫자(0~9까지) 10개를 배열에 담아 나온수의 갯수를 세어주세요.

	public static void main(String[] args) {

		int[] arr = new int[10];
		int[] cnt_arr = new int[10];

		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		System.out.println(Arrays.toString(arr));

		int counter = 0;
		int tNum = 0;

		for (; tNum < 10; tNum++) {
			for (int i = 0; i < 10; i++) {
				if (tNum == arr[i]) {
					counter++;
				}
			}
			cnt_arr[tNum] = counter;
			counter = 0;
		}

		System.out.println(Arrays.toString(cnt_arr));
	}
}

class AA {

	public static void doA() {
		System.out.println("AA.doA() 메서드입니다.");
	}

}