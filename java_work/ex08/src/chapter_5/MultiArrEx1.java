package chapter_5;
import java.util.*;

class MultiArrEx1 {
	public static void main(String[] args) {
		final int SIZE = 10;
		int x = 0, y = 0;

		char[][] board = new char[SIZE][SIZE];
		byte[][] shipBoard = {
		  //  1  2  3  4  5  6  7  8  9
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 1
			{ 1, 1, 1, 1, 0, 0, 1, 0, 0 }, // 2
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 3
			{ 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 4
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
			{ 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 6
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 7
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 8
			{ 0, 0, 0, 0, 0, 1, 1, 1, 0 }, // 9
		};

	     // 0�࿡ ���ȣ��, 0���� ����ȣ�� �����Ѵ�. 
		for(int i=1;i<SIZE;i++)
			board[0][i] = board[i][0] = (char)(i+'0');

		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.printf("��ǥ�� �Է��ϼ���.(����� 00)>");
			String input = scanner.nextLine(); // ȭ���Է¹��� ������ tmp�� ����

			if(input.length()==2) {   // �� ���ڸ� �Է��� ���
				x = input.charAt(0) - '0';  // ���ڸ� ���ڷ� ��ȯ
				y = input.charAt(1) - '0';

				if(x==0 && y==0) // x�� y�� ��� 0�� ��� ����
					break; 
			} 
			
			if(input.length()!=2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE){
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
				continue;
			}

			// shipBoard[x-1][y-1]�� ���� 1�̸�, 'O'�� board[x][y]�� �����Ѵ�.  
			board[x][y] = shipBoard[x-1][y-1]==1 ? 'O' : 'X';  

			// �迭 board�� ������ ȭ�鿡 ����Ѵ�.
			for(int i=0;i<SIZE;i++) {
				System.out.println(board[i]); // board[i]�� 1���� �迭
			}
			System.out.println();
		}
	} // main�� ��
}
