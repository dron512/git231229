package ex14;

public class Ex04 {

	public static void main(String[] args) {
	
		String a = "abc";
		String b = new String("abc");
		String c = "abc";
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println("a==b  "+ (a==b));
		System.out.println("a==c  "+ (a==c));
		
		System.out.println("a.equals(b) "+a.equals(b));
		System.out.println("a.equals(c) "+a.equals(c));
	}
}
