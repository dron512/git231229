package ex10;

// java -> class
// TV.class

public class Ex03 {
	// 같은 패키지 내에서는 같은 클래스명이 존재하면 안됩니다.
	public static void main(String[] args) {
		
		// class Tv 안에는 채널, 색상, 전원.. 변수로..
		// 캡슐화...
		int a;
		int b;
		int c;
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		Tv tv3 = new Tv();
		Tv tv4 = new Tv();
		Tv tv5 = new Tv();
		Tv tv6 = new Tv();
		Tv tv7 = new Tv();
		
		tv1.channel = 10;
		
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		
		tv1.channelUp();
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		
		
	}
}
