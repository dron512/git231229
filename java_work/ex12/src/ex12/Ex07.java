package ex12;

class Accumulator {

	public static int sum = 0;

	public static void add(int i) {
//		sum += i;
		sum = sum + i;
	}

	public static void showResult() {
		System.out.println("sum = " + sum);
	}
}

public class Ex07 {
	public static void main(String[] args) {
		// 메모리에 올라간다
//		Accumulator ac = new Accumulator();
		
		System.out.println(Accumulator.sum);
		
		for (int i = 0; i < 10; i++) {
			Accumulator.add(i);
		}
		
		Accumulator.showResult();

	}
}

