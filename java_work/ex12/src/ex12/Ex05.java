package ex12;

class CapA{
	public void take() {
		System.out.println("CapA 약묵음 기침 나음");
	}
}
class CapB{
	public void take() {
		System.out.println("CapA 약묵음 콧물 나음");
	}
}
class CapC{
	public void take() {
		System.out.println("CapA 약묵음 열인제 안남");
	}
}
class ColdPatient{
	void takeA(CapA a) {
		a.take();
	}
	void takeB(CapB b) {
		b.take();
	}
	void takeC(CapC c) {
		c.take();
	}
	void takeAll(CapA a, CapB b, CapC c) {
		a.take(); b.take(); c.take();
	}
}

public class Ex05 {
	public static void main(String[] args) {
		ColdPatient cp = new ColdPatient();
//		cp.takeC(new CapC());
//		cp.takeB(new CapB());
//		cp.takeA(new CapA());
		cp.takeAll(new CapA(), new CapB(), new CapC());
		
		
	}
}
