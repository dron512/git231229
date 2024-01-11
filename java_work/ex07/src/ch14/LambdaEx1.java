package ch14;
@FunctionalInterface
interface MyFunction {
	void run();  // public abstract void run();
}

class LambdaEx1 {
	static void execute(MyFunction f) { // �Ű������� Ÿ���� MyFunction�� �޼���
		f.run();
	}

	static MyFunction getMyFunction() { // ��ȯ Ÿ���� MyFunction�� �޼��� 
		MyFunction f = () -> System.out.println("f3.run()");
		return f;
	}

	public static void main(String[] args) {
		// ���ٽ����� MyFunction�� run()�� ����
		MyFunction f1 = ()-> System.out.println("f1.run()");

		MyFunction f2 = new MyFunction() {  // �͸�Ŭ������ run()�� ����
			public void run() {   // public�� �ݵ�� �ٿ��� ��
				System.out.println("f2.run()");
			}
		};

		MyFunction f3 = getMyFunction();

		f1.run();
		f2.run();
		f3.run();

		execute(f1);
		execute( ()-> System.out.println("run()") );
	}
}
