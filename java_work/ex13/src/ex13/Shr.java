package ex13;

/* Math.random() 메소드 대신 Random 클래스를 이용
 * 길이 10의 배열을 선언하고 랜덤한 값을 넣어 출력
 */

import java.util.Arrays;
import java.util.Random;

public class Shr {
	public static void main(String[] args) {
		Random random = new Random(); // Random 클래스를 사용하여 난수 생성을 위한 객체 'random'생성
		int[]arr = new int[10]; // 크기가 10인 정수 배열 생성
		
		for (int i = 0; i < arr.length; i++) { // 배열 arr에 0이상 10미만의 난수를 할당
			arr[i] = random.nextInt(10); // 0부터 9까지의 난수를 반환
			
			//arr[i] = (int) (Math.random() * 10);
		}
		System.err.println(Arrays.toString(arr)); // 배열을 문자열 형태로 변환하여 출력
	}
}
