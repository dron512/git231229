package aa;

public class Ex03 {
	/*
	 * [1, 2, 3, 3, 3, 4] 3 [1, 1, 2, 2] -1 [1] 1
	 */
	public static int solution(int[] array) {
		int[] realArr = new int[array.length];
		int[] cntArr = new int[array.length];

		int rcnt = 0;
		// realArr 만들기
		for (int i = 0; i < realArr.length; i++) {
			int count = 0;
			for (int j = 0; j < realArr.length; j++) {
				if (array[i] == realArr[j]) {
					count++;
				}
			}
			if (count == 0) {
				realArr[rcnt++] = array[i];
			}
		}
		
		rcnt = 0;
		// cntArr 만들기
		for (int i = 0; i < realArr.length; i++) {
			int count = 0;
			for (int j = 0; j < realArr.length; j++) {
				if (realArr[i] == array[j]) {
					count++;
				}
			}
			cntArr[rcnt++] = count - 1;
		}
		
		int max = cntArr[0];
		// 최빈값 구하기
		for (int i = 1; i < cntArr.length; i++) {
			if (max < cntArr[i])
				max = cntArr[i];
		}
		
		int same = 0;
		// 최빈값이 있는지 비교.....
		for (int i = 0; i < cntArr.length; i++) {
			if (cntArr[i] == 0 || cntArr[i] == -1)
				continue;
			if (max == cntArr[i])
				same++;
		}
		
		if (same>1) { max=-1; } else { max++; };
		
		System.out.println("최빈값은 = " + max + " 입니다");
		return max;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 3, 3, 4 };
		int arr2[] = { 1, 1, 2, 2 };
		int arr3[] = { 1 };

		solution(arr1);
		solution(arr2);
		solution(arr3);
	}
}
