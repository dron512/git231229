package ex12;

public class Tri {
	int width;
	int height;

	public Tri() {
	} // 기본생성자.
	// alt + shift + s -> o 다른생성자...기본생성자 생략불가..

	public Tri(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// alt + shift + s -> s
	@Override
	public String toString() {
		return "Tri [width=" + width + ", height=" + height + "]";
	}
	// 넓이를 구하는 메서드

	public double area() {
		return width * height * 0.5;
	}
}
