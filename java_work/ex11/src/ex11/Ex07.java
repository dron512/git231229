package ex11;

class A{
	public void doA() {
		System.out.println("A doA");
	}
}

class B{
	public void doB() {
		System.out.println("B doB");
	}
}

class C{
	public void doC() {
		System.out.println("C doC");
	}
}

public class Ex07 {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		a.doA();
		b.doB();
		c.doC();
	}
	
}
