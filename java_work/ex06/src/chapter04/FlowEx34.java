package chapter04;
import java.util.*;

class FlowEx34 {
	public static void main(String[] args) { 
		int menu = 0;
		int num  = 0;

		Scanner scanner = new Scanner(System.in);

		outer:
		while(true) {
			System.out.println("(1) square");
			System.out.println("(2) square root");
			System.out.println("(3) log");
			System.out.print("���ϴ� �޴�(1~3)�� �����ϼ���.(����:0)>");

			String tmp = scanner.nextLine(); // ȭ�鿡�� �Է¹��� ������ tmp�� ����
			menu = Integer.parseInt(tmp);    // �Է¹��� ���ڿ�(tmp)�� ���ڷ� ��ȯ

			if(menu==0) {  
				System.out.println("���α׷��� �����մϴ�.");
				break;
			} else if (!(1<= menu && menu <= 3)) {
				System.out.println("�޴��� �߸� �����ϼ̽��ϴ�.(����� 0)");
				continue;		
			}

			for(;;) {
		    System.out.print("����� ���� �Է��ϼ���.(��� ����:0, ��ü ����:99)>");
				tmp = scanner.nextLine();   // ȭ�鿡�� �Է¹��� ������ tmp�� ����
				num = Integer.parseInt(tmp); // �Է¹��� ���ڿ�(tmp)�� ���ڷ� ��ȯ

				if(num==0)  
					break;        // ��� ����. for���� �����.
				if(num==99) 
					break outer;  // ��ü ����. for���� while���� ��� �����.

				switch(menu) {
					case 1: 
						System.out.println("result="+ num*num);		
						break;
					case 2: 
						System.out.println("result="+ Math.sqrt(num)); 
						break;
					case 3: 
						System.out.println("result="+ Math.log(num));  
						break;
				} 
			} // for(;;)
		} // while�� ��
	} // main�� ��
}
