package chapter04;

class FlowEx22 {
	public static void main(String[] args) {
		
		int[] arr = { 10, 20, 30, 40, 50 };
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();

		for (int tmp : arr) {
			System.out.printf("%d ", tmp);
			sum += tmp;
		}
		System.out.println();
		System.out.println("sum=" + sum);
		
	} 
}

