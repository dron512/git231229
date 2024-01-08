package chapter04;
import java.util.*;

class FlowEx11 {
	public static void main(String[] args) { 
		char gender;
		String regNo = "";
		System.out.print("����� �ֹι�ȣ�� �Է��ϼ���.(011231-1111222)>");

		Scanner scanner = new Scanner(System.in);
		regNo = scanner.nextLine();

		gender = regNo.charAt(7); // �Է¹��� ��ȣ�� 8��° ���ڸ� gender�� ����

		switch(gender) {
			case '1':
			case '3':
				switch(gender) {
					case '1':
					System.out.println("����� 2000�� ������ ����� �����Դϴ�.");
						break;
					case '3':
					System.out.println("����� 2000�� ���Ŀ� ����� �����Դϴ�.");
				}
				break;    // �� break���� ������ �ʵ��� ����
			case '2':
			case '4':
				switch(gender) {
					case '2':
					System.out.println("����� 2000�� ������ ����� �����Դϴ�.");
						break;
					case '4':
					System.out.println("����� 2000�� ���Ŀ� ����� �����Դϴ�.");
						break;
				}
				break;
			default:
				System.out.println("��ȿ���� ���� �ֹε�Ϲ�ȣ�Դϴ�.");;
		}
	} // main�� ��
}
