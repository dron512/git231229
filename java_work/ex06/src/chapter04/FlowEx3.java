package chapter04;
import java.util.*; // ScannerŬ������ ����ϱ� ���� �߰�

class FlowEx3 {
	public static void main(String[] args) {  
		int input;

		System.out.print("���ڸ� �ϳ� �Է��ϼ���.>");

		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); // ȭ���� ���� �Է¹��� ������ tmp�� ����
		input = Integer.parseInt(tmp);   // �Է¹��� ���ڿ�(tmp)�� ���ڷ� ��ȯ

		if(input==0) {
			System.out.println("�Է��Ͻ� ���ڴ� 0�Դϴ�.");	
		} else { // input!=0�� ���
			System.out.println("�Է��Ͻ� ���ڴ� 0�� �ƴմϴ�.");
		}
	} // main�� ��
}
