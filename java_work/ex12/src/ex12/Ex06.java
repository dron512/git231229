package ex12;

public class Ex06 {

	public int doA(int a,int b) {
		int sum = a+b;
		return sum;
	}
	
	public void Test(int num1) {
		int num2;
		
		int sum = doA(10,20);
		System.out.println(sum);
//		System.out.println(doA(10,20));
	}
	
	public Ex06() {
//		System.out.println(doA(10,20));
	}

	public static void main(String[] args) {
		new Ex06();
	}
}
