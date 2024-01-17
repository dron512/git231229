package ex12;

/*
 * import java.lang.*
 * toString
 * 기본생성자
 * 생성자바로밑에 쓰는 super(); 생략가능
 */
// 밑변과 높이를 저장할수 있는 생성자
// 밑변과 높이로 넓이를 구하는 메서드
// 클래스 내에서는 여러 생성자를 선언할수 있다.
// 클래스 내에서는 클래스 변수와 클래스 메서드를 선언할 수 있다.

public class Ex01 {
	public static void main(String[] args) {
		Tri t1 = new Tri(10,20);
		Tri t2 = new Tri();
		
		System.out.println(t1);
		System.out.println(t2);
		
		System.out.println(t1.area());
		System.out.println(t2.area());
		
	}
}
