package ex11;

public class Ex08 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		hieveryone(12, 170);
		hieveryone(13, 180);
		hieveryone(14, 190);
		hieveryone(15, 200);
		System.out.println("프로그램 끝");
	}

	public static void hieveryone(int age, double height) {
		System.out.println("안녕하세요");
		System.out.println("제 나이는 " + age + "세 입니다.");
		System.out.println("제 키는 " + height + " 입니다");
	}

}
