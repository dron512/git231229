package ex10;

// 생략되어진 표현
// import java.lang.*;
// 기본생성자 
public class Ex06 {
	
	//생성자 메서드 아주조끔....
	// 생성자는 리턴되는값이 안적혀져 있어요..
	// 메서드는 리턴되는값이 적혀져 있어요..
	
	// 클래스 함수는 인스턴스화 해야지만 사용할 수 있다.
	public void doA() {
		System.out.println("doA 메서드 입니다.");
	}
	
	// static 은 메모리 공간에 항상 상주 한다...
	public static void doB() {
		System.out.println("doB 메서드 입니다.");
	}
	
	// alt + shift + s -> c 기본생성자 만들기
	public Ex06(){	//생성자... constructor
		System.out.println("기본생성자...");
	}

	public static void main(String[] args) {
		// new Ex06();
		Ex06 ex06 = new Ex06();
		ex06.doA(); // 인스턴스함수...호출...
		
//		Ex06.doA();
		Ex06.doB();	// static 함수...
		
		System.out.println();
	}

}
