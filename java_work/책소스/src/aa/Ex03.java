package aa;

public class Ex03 {
	public static int solution(int[] array) {
		int[] realArr = new int[array.length];
		int[] cntArr = new int[array.length];

		for (int i = 0; i < realArr.length; i++) {
			realArr[i] = -1;
		}

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
			cntArr[rcnt++] = count;
		}

		int max = cntArr[0];
		int index = 0;
		// 최빈값 구하기
		for (int i = 1; i < cntArr.length; i++) {
			if (max < cntArr[i]) {
				max = cntArr[i];
				index=i;
			}
		}
		System.out.println("최빈값은 = " + realArr[index] + " 입니다");

		int same = 0;
		// 최빈값이 있는지 비교.....
		for (int i = 0; i < cntArr.length; i++) {
			if (cntArr[i] == 0)
				continue;
			if (max == cntArr[i])
				same++;
		}

		if (same > 1) {
			max = -1;
		}

		if(max==-1)
			return -1;
		else
			return realArr[index];
	}

	public static void main(String[] args) {
		int arr1[] = { 0, 0, 1 };
		int arr2[] = { 1, 1, 2, 2, 0, 0, 0 };
		int arr3[] = { 1 };
		int arr4[] = { 1, 2, 3, 4 };
		int arr5[] = { 10, 11, 12, 13 };

		solution(arr1);
		solution(arr2);
		solution(arr3);
		solution(arr4);
		solution(arr5);
	}
}
