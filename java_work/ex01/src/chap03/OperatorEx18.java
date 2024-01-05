package chap03;

class OperatorEx18 {
	public static void main(String args[]) { 
		/*
		 * Scanner scan = new Scanner();
		 * scan.nextInt();
		 * scan.next()
		 * scan.nextLine();
		 * 
		 * 반올림...함수..
		 * Math.round()
		 * 0< x <1 사이에 값 랜덤하게 구하기 
		 * Math.random()
		 */
		
		System.out.println(Math.random());
		
		
		double pi = 3.141592; 
		double shortPi = Math.round(pi * 1000) / 1000.0;

		System.out.println(shortPi);
	}
}
