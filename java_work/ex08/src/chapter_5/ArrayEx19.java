package chapter_5;
class ArrayEx19 {
	public static void main(String[] args) {
		 int[][] score = {
							{ 100, 100, 100}
							, { 20, 20, 20}
							, { 30, 30, 30}
							, { 40, 40, 40}
							, { 50, 50, 50}
						};
		// ���� ����
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;

	    System.out.println("��ȣ ���� ���� ���� ���� ��� ");
	    System.out.println("=============================");

		for(int i=0;i < score.length;i++) {
			int   sum = 0;       // ���κ� ����
			float avg = 0.0f;   // ���κ� ���

			korTotal  += score[i][0];
			engTotal  += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%3d", i+1);

			for(int j=0;j < score[i].length;j++) {
				sum += score[i][j]; 
				System.out.printf("%5d", score[i][j]);
			}

			avg = sum/(float)score[i].length;  // ��հ��
			System.out.printf("%5d %5.1f%n", sum, avg);
		}

	    System.out.println("=============================");
	    System.out.printf("����:%3d %4d %4d%n", korTotal, engTotal, mathTotal);
	}
}
