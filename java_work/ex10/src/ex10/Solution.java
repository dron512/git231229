package ex10;

public class Solution {
	// 프로그램시작과 동시에 메모리에 상주된다... 프로그램종료시에
	public Solution() {
		String num = "78720646226947352489";
		solution(num);
	}

	public int solution(String number) {
		int answer = 0;
		char[] arr = number.toCharArray();
		int[] brr = new int[arr.length];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			brr[i] = arr[i] - 48;
		}

		for (int i = 0; i < arr.length; i++) {
			sum = sum + brr[i];
		}
		answer = sum % 9;
		return answer;
	}

	public static void main(String[] args) {
		new Solution(); // heap 영역...
	}
}
