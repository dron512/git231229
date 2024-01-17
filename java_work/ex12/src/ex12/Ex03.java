package ex12;

public class Ex03 {

	public static void main(String[] args) {
		Circle c1 = new Circle();
//		c1.rad = 10;
		c1.setRad(10);
		
//		System.out.println(c1.rad);
		System.out.println(c1.getArea());
		
		Circle c2 = new Circle(20);
		System.out.println(c2.getArea());
		
//		c1.rad = -3;
		c1.setRad(-3);
		
	}
}
