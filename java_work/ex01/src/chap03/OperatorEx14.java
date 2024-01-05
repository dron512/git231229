package chap03;

class OperatorEx14 {
	public static void main(String[] args) {
		char c = 'a';
		// i = 0 부터.... 25까지..
		// for 기간...
		for (int i = 0; i < 26; i++) {
			System.out.print(c++);
		}

		System.out.println();

		c = 'A';
		for (int i = 0; i < 26; i++) {
			System.out.print(c++);
		}

		System.out.println();

		c = '0';
		for (int i = 0; i < 10; i++) {
			System.out.print(c++);
		}
		System.out.println();
	}
}
