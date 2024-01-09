package chapter04;

class FlowEx20 {
	public static void main(String[] args) {
		
		// i=1일때 j= 1~5
		// i=2일떄 j= 1~5
		// i=3일때 j= 1~5
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 15; j=j+3) {
//				System.out.printf("[%d,%d]", i, j);
				System.out.print("["+i+","+j+"]");
			}
			System.out.println();
		}
		
	}
}
