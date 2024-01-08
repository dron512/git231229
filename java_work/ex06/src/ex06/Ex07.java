package ex06;

public class Ex07 {

	public static void main(String[] args) {

		// 0에서 9까지 합을 출력해주세요
		// 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = ?
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			sum = sum + i;
			System.out.println("sum = "+sum);
		}
		System.out.println("sum = "+sum);

	}

}
