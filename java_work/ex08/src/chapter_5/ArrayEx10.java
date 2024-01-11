package chapter_5;

class ArrayEx10 {
	public static void main(String[] args) {
		int[] numArr = new int[10];

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = (int) (Math.random() * 10);
			System.out.println(numArr[i]);
		}
		System.out.println();

		// i = 0 부터 8까지...
		for (int i = 0; i < numArr.length - 1; i++) {
			boolean changed = false;
			
			// numArr 값 출력 하는 반복문
			for (int k = 0; k < numArr.length; k++) {
				System.out.print(numArr[k]);
			}
			
			for (int j = 0; j < numArr.length - 1 - i; j++) {
				if (numArr[j] > numArr[j + 1]) {
					int temp = numArr[j];
					numArr[j] = numArr[j + 1];
					numArr[j + 1] = temp;
					changed = true;
				}
			} // end for j

			if (!changed)
				break;

			for (int k = 0; k < numArr.length; k++) {
				System.out.print(numArr[k]);
			}
			System.out.println();
		} // end for i
	} // main�� ��
}
