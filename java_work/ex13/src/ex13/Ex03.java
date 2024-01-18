package ex13;

class AA{
	public void doPrint() {
		System.out.println("스태틱 doPrint()");
	}
}
class AAA{
	public static AA aa = new AA();
	public void doA() {
		System.out.println("AAA doA");
	}
	void main(String[] args) {
		System.out.println("실행...");
	}
}
public class Ex03 {
	public static void main(String[] args) {
		AAA aa = new AAA();
		aa.doA();
		
		AAA.aa.doPrint();
		
		System.out.println("테스트");
	}
}
