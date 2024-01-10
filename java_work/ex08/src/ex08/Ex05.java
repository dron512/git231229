package ex08;

public class Ex05 {

	public static void main(String[] args) {
		// i==0일때 j=0~9
		// i==1일때 j=0~9
		// i==2일때 j=0~9
		// i==3일때 j=0~9
		// i==4일때 j=0~9
		// i==5일때 j=0~9
		// ...
		// 3 6 9 일때 출력하지 마라
		// j==7일때 i값이 증가해라
		
		// k =0 일때 i=0일때 j=0~9
		// k =0 일때 i=1일때 j=0~9
		// k =0 일때
		for (int k = 0; k < 10; k++)
			aa: for (int i = 0; i < 10; i++) {
				System.out.println("i = " + i);
				for (int j = 0; j < 10; j++) {

					if (j == 3 || j == 6 || j == 9) {
						continue;
					}
					if (j == 7) {
						i = i + 1;
						System.out.println("여기 왔냐");
						break aa;
					}

					System.out.println("\t j = " + j);

				}

			}
	}
}
