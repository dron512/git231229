package chap03;
import java.util.*;  // ScannerŬ������ ����ϱ� ���� �߰�

class OperatorEx25 {
	public static void main(String args[]) { 
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';

		System.out.printf("���ڸ� �ϳ� �Է��ϼ���.>");

		String input = scanner.nextLine();
		ch = input.charAt(0);

		if('0'<= ch && ch <= '9') {
			System.out.printf("�Է��Ͻ� ���ڴ� �����Դϴ�.\n");
		}

		if(('a'<= ch && ch <= 'z') || ('A'<= ch && ch <= 'Z')) {
			System.out.printf("�Է��Ͻ� ���ڴ� �������Դϴ�.\n");
		}
	} // main
}
