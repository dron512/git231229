package ex11;

public class Ex09 {

	public static void main(String[] args) {
		System.out.println(doAdd(10, 20));

		System.out.println(divide(5, 4));
		System.out.println(divide(10, 0));
		
		{
			int num = 10;
			System.out.println(num);
		}
		
	}

	public static int doAdd(int num1, int num2) {
		int result = num1 + num2;
		return result;
	}

	public static int divide(int num1, int num2) {
		if (num2 == 0) {
			System.out.println("0으로 나눌수 없습니다.");
			return 1;
		}
		int result = num1 / num2;

		return result;
	}
}
