package ex13;

public class Ksu {
	public static void main(String[] args) {
		Orange or = new Orange();
		
		if(or instanceof Orange) {
			System.out.println("이것은 Orange 클래스의 인스턴스입니다.");
		}
		if(or instanceof Fruit) {
			System.out.println("이것은 Fruit 클래스의 인스턴스입니다.");
		}
		if(or instanceof Object) {
			System.out.println("이것은 Object 클래스의 인스턴스입니다.");
		}
		System.out.println(or.getClass().getName());
	}
	}// class
	class Fruit{}
	class Orange extends Fruit{}



