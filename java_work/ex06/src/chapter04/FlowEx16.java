package chapter04;

class FlowEx16 {
	public static void main(String[] args) {

		// i=1 일떄 j = 1~10
		// i=2 일때 j = 1~10
		// i=3 일때 j = 1~10
		// i=4 일때 j = 1~10
		// i=5 일떄 j = 1~10
		for (int i = 1; i <= 5; i++) {
//			System.out.println("i = " + i);
			for (int j = 1; j <= 10; j++) {
//				System.out.println(" j = " + j);
				System.out.print("*");
			}
			System.out.println();
		}
	} // main�� ��
}
