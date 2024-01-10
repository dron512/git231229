package ex08;

// 1~ 46
// random한 숫자 3개를 꺼내서 같은 숫자가 나오면 true 출력하고 아니면 false

public class Ex04 {

	public static void main(String[] args) {

		int a = 0, b = 0, c = 0;

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		// 0 < x < 1
		// 0 < x < 45
		// 0.000001 ~ 44.99999
//		for (int i = 0; i < 100; i++)
//			System.out.println((int) (Math.random() * 45));
		a = (int) (Math.random() * 45) + 1;
		b = (int) (Math.random() * 45) + 1;
		c = (int) (Math.random() * 45) + 1;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);

		// a b c
		
		System.out.println(a==b || a==c || b==c);
	}

}














