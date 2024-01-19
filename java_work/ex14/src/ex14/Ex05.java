package ex14;

public class Ex05 {

	public static void main(String[] args) {
		String a = "abc";
		String b = "def";
		
		System.out.println(a+b);
		System.out.println(a.concat(b));
		
		System.out.println(a.substring(1));
		System.out.println("abcdefgh".substring(0,4));
		
		String c = "abcdefg";
		String d = "abcdefg";
		
		System.out.println(c.compareTo(d));
		System.out.println("A".compareTo("B"));
		System.out.println("B".compareTo("A"));
	}
}
