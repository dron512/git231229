package ex06;

import java.util.Scanner;

/*
 *
 * KOI 전자에서는 건강에 좋고 맛있는 훈제오리구이 요리를 간편하게 만드는 인공지능 오븐을 개발하려고 한다. 
 * 인공지능 오븐을 사용하는 방법은 적당한 양의 오리 훈제 재료를 인공지능 오븐에 넣으면 된다. 
 * 그러면 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다.
 * 또한, KOI 전자의 인공지능 오븐 앞면에는 사용자에게 훈제오리구이 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다.
 * 훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때, 오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
 * 
 *  첫째 줄에는 현재 시각이 나온다. 
 *  현재 시각은 시 A (0 ≤ A ≤ 23) 와
 *   분 B (0 ≤ B ≤ 59)가 정수로 빈칸을 사이에 두고 순서대로 주어진다. 
 *   
 *  두 번째 줄에는 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
 */
public class Ex05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//		System.out.println("현재 시간 입력");
		String hourMin = scan.nextLine();

		int hour = Integer.parseInt(hourMin.split(" ")[0]);
		int min = Integer.parseInt(hourMin.split(" ")[1]);

//		System.out.println("현재 시간 = " + hour + " 시 " + min + "분");

//		System.out.println("걸리는 시간 입력");
		int forMin = scan.nextInt();
//		System.out.println("걸리는 시간 " + forMin);

		min = min + forMin;
		// 61 /60 -> hour 1증가
		// 121 /60 -> hour 2증가
		// 181 /60 -> hour 3증가
		if (min >= 60) {
			hour = hour + ( min / 60 );
			min = min % 60;
		}
		// hour 24 시이면... 24 로 나누었을때 나머지를 시간으로 변경
		// hour 25시 -> 1시
		// 25%24 -> 1
		// 49%24 -> 1
		// 28%24 -> 4
		if (hour >=24){
			hour = hour % 24;
		}
		System.out.println(hour + " " + min);

	}
}











