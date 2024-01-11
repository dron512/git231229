package ex09;

public class Ex02 {
	
	public static int solution(int[] num_list) {
		int answer = 0;

		int rha = num_list[0];
		int gkqdmlwprhq = num_list[0];
		
		for (int i = 1; i < num_list.length; i++) {
			rha = rha * num_list[i];
			gkqdmlwprhq += num_list[i];
		}
		
		if( rha > gkqdmlwprhq*gkqdmlwprhq )
			answer = 0;
		else
			answer = 1;
		
		return answer;
	}
	
	public static void main(String[] args) {
//		int[] num_list = {3,4,5,2,1};
		int[] num_list = {5,7,8,3};
		
		solution(num_list);
		
//		ctrl + shift + c, ctrl + / 주석설정 및 해제		
//		System.out.println(3 * 4 * 5 * 2 * 1);
//		System.out.println((3 + 4 + 5 + 2 + 1) * (3 + 4 + 5 + 2 + 1));
//		
//		System.out.println(5 * 7 * 8 * 3);
//		System.out.println((5 + 7 + 8 + 3) * (5 + 7 + 8 + 3));
	}

}
