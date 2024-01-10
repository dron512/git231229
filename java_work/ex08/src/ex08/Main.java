package ex08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int total = 0;	// 영수증에 총값
		int productCnt = 0; // 영수증에 구매한 물건 갯수
		int calcu_total = 0; // 직접 계산한 총값
		
		total = scan.nextInt();	        //260000
		productCnt = scan.nextInt();	//4
		
		// 배열만들기
		int[] itemPrice = new int[productCnt];
		int[] itemCnt = new int[productCnt];
		
		System.out.println(total);
		System.out.println(productCnt);
		
//		while ( scan.hasNext() ) scan.next();
		
		for( int i=0; i<productCnt; i++) {
			String temp = scan.nextLine();
			System.out.println(temp);
			itemPrice[i] = Integer.parseInt(temp.split(" ")[0]);
			itemCnt[i] = Integer.parseInt(temp.split(" ")[1]);
		}
		
		for( int i=0; i<productCnt; i++) 
			calcu_total = calcu_total + (itemPrice[i] * itemCnt[i]);
		
		if(total == calcu_total)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		/*
		 * 260000 4 20000 5 30000 2 10000 6 5000 8
		 */
		/*
		 * 250000 4 20000 5 30000 2 10000 6 5000 8
		 */

	}

}
