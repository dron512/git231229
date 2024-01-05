package ex05;

public class Ex05 {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		boolean c = a>b && b> (b=30);

		System.out.println(c);
		System.out.println(b);
		
		boolean d = a<b || b> (b=30);
		
		System.out.println(d);
		System.out.println(b);
		
		boolean e = a<b && b> (b=30);

		System.out.println(e);
		System.out.println(b);

	}
}
