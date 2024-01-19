package ex14;

/*
 * 생성자 오버로딩
 * 메서드 오버로딩
 * 
 * 클래스 인스턴스화 -> 메모리에 이클래스 메모리 에 올린다.
 */
public class Ex01 {
	Ex01(){
		System.out.println("기본 생성자");
	}
	Ex01(int a, int b){
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
	Ex01(String c){
		System.out.println("c = "+c);
	}
	public static void main(String[] args) {
		new Ex01();
		new Ex01(10,20);
		new Ex01("문자열 출력");
	}
}
