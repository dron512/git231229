package ex10;

/*
 * Tv라는 객체를 클래스로 만들도록 한다...
 * 
 * 속성 과 기능..
 * 변수... 메서드...
 */
public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		Tv tv1 = new Tv();
		
		System.out.println(tv1.color);
		System.out.println(tv1.power);
		System.out.println(tv1.channel);
		
		tv1.power();
		
		System.out.println(tv1.power);
		tv1.channdelDown();
		System.out.println(tv1.channel);
		tv1.channelUp();
		System.out.println(tv1.channel);
		
		// JVM free();
		// PVM 알아서...
//		tv1 = null;
	}
}
