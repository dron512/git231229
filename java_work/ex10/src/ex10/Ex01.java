package ex10;

/*
 * 5*5 배열에다가 
 * 임의의 랜덤한 숫자 넣어 출력해보기(1~100)
 */
public class Ex01 {
	// for if while 구문 system.out.println();
	public static void doPrintArr(int[][] arr) {
		for (int i = 0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				arr[i][j] = (int) (Math.random()*100)+1;
			}
		}
		
		for (int i = 0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int[][] brr = new int[5][5];
		
		doPrintArr(arr);
		doPrintArr(brr);

		
		
	}
	
	
}
