package aaa;

class A{
	protected int num = 10;
}

public class B extends A{
	int num2 = 20;
	public void doNum() {
		System.out.println(num);
	}
}
