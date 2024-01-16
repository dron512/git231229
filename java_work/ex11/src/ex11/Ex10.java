package ex11;

public class Ex10 {

	public static void main(String[] args) {

		int result = fact(5);
		
		// fact(5)
		// 2*fact(4)
		// 2*2*fact(3)
		// 2*2*2*fact(2)
		// 2*2*2*2*fact(1)
		
		for( int i =0; i<5 ; i++) {
			
		}
		
		System.out.println(result);
		
		// 재귀함수를 사용해서 doA(5)
		// 2*2*2*2*2 했는 결과 나오도록 재귀함수 만드세요...
	}

	public static int fact(int num) {
		if (num > 0)
			return 2 * fact(num - 1);
		else
			return 1;
	}
}
