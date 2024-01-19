package ex14;

public class Ex02 {

	public static void main(String[] args) {
	
		AA a1 = new AA();
		a1.doA();
		a1.doA(10, 20);
		a1.doA("문자열");
		
		
		AA.doB();
		AA.doB(30,40);
		AA.doB("바로 호출가능하다.");
	}
	
}
