package chapter04;
class FlowEx26 {
	public static void main(String[] args) { 
		int sum = 0;
		int i   = 0;

		while((sum += ++i) <= 100) { // i�� 1�� �������Ѽ� sum�� ��� ���س�����.
			System.out.printf("%d - %d%n", i, sum);
		}
	} // main�� ��
}
