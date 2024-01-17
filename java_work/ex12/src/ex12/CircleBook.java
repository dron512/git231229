package ex12;

/*
 * 변수      메서드
 * 반지름설정, 원넓이구하기
 */
public class CircleBook {
	
	// 다른 클래스에서 이 변수 참조 불가입니다.
	private int rad;
	
	// final 값 변경 불가
	final double PI = 3.14;
	
	public CircleBook() {}
	
	// alt+ shift + s -> o 단축키
	public CircleBook(int rad) {
		this.rad = rad;
	}

	public void setRad(int r) {
		if (r < 0) { this.rad = 0; return; }
		this.rad = r;
	}
	
	public double getArea() {
		return rad * rad * PI;
	}
	
}
