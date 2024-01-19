package ex14;

public class AA {

	public int doC() {
		System.out.println("AA doA");
		return 10;
	}
	
	public void doA() {
		System.out.println("AA doA");
	}
	public void doA(int a,int b) {
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
	public void doA(String c) {
		System.out.println("c = "+c);
	}
	public static void doB() {
		System.out.println("AA doA");
	}
	public static void doB(int a,int b) {
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
	public static void doB(String c) {
		System.out.println("c = "+c);
	}
}
