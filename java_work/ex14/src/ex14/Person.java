package ex14;

public class Person {

	private int regNum;
	private int passNum;
	
	public Person(int regNum) {
		System.out.println("regNum 생성자");
		this.regNum = regNum;
	}

	// alt + shift + s -> o
	public Person(int regNum, int passNum) {
		this(regNum);
		System.out.println("regNum 생성자 passNum 생성자");
//		this.regNum = regNum;
		this.passNum = passNum;
	}

	// alt + shift + s -> s 
	@Override
	public String toString() {
		return "Person [regNum=" + regNum + ", passNum=" + passNum + "]";
	}
	
}
