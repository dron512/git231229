package ex13;

class InstClass {
	static int num = 20;

	InstClass() {
		System.out.println("생성자 호출 " + num);
	}
}

public class Ex01 {

	public static void main(String[] args) {

		InstClass.num = 10;

		new InstClass();
		new InstClass();
		new InstClass();

		System.out.println(InstClass.num);
	}

}
