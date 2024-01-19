package ex14;

class A{}

public class Ex03 {

	// ctrl + shift + w 모든 창 닫기
	// ctrl + w 현재 창 닫기
	
	// istj... intj...
	
	public static void main(String[] args) {
		A a = new A();
		Object b = new A();
		
		if( a instanceof Object)
			System.out.println("가능하다");
		
		
		Person p1 = new Person(850511, 1231234);
		System.out.println(p1);
		
		Person p2 = new Person(750511);
		System.out.println(p2);
	}
}
