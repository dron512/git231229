package ex10;

public class Ex09 {
	
	// 기본생성자
	// static 변수 static 함수
	// 클래스 생성 인스턴스화.. 메모리에 올린다..
	
	Ex09(){
		System.out.println("기본생성자");
	}
	
	public static void doA() {
		System.out.println("static함수");
	}
	
	public void doB() {
		System.out.println("non-static함수");
	}

	public static void main(String[] args) {
//		doB();
//		Ex09.doB();
		
		doA();
		Ex09.doA();
		
		Ex09 ex09 = new Ex09();
		ex09.doA();
		
		ex09.doB();
		
	}
}
