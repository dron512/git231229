package ex13;

/*
 * 정수가 담긴 리스트 num_list가 주어집니다. 
 * num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 
 * return하도록 solution 함수를 완성해주세요.
 */


class Solution {
	int answer = 0;
	public int solution(int[] num_list) {
		// 짝수만 붙인 수(문자열)
		// 홀수만 붙인 수(문자열)
//		String even = "";
//		String odd = "";
		// StringBuilder 사용시 성능향상
		// String 객체 선언은 불러 올때마다 새로운 객체를 선언 StringBuilder는 선언된 객체내용만 반환 -> 문자열을 붙이는 경우 효율적
		StringBuilder evenStr = new StringBuilder();
		StringBuilder oddStr = new StringBuilder();

		for(int i=0; i<num_list.length; i++) {
			if(num_list[i] % 2 == 0) {
//				even += num_list[i];
				evenStr.append(Integer.toString(num_list[i]));
//				System.out.println(evenStr.toString());
			} else {
//				odd += num_list[i];
				oddStr.append(Integer.toString(num_list[i]));
//				System.out.println(oddStr.toString());
			}
		}
//		answer = Integer.parseInt(even) + Integer.parseInt(odd); 
		answer = Integer.parseInt(evenStr.toString()) + Integer.parseInt(oddStr.toString());
		System.out.println(answer);
		return answer;
	}
}

public class Kanghyun {
	static int[] num_list = {3,4,5,2,1};
	static int[] num_list2 = {5,7,8,3};
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(num_list);
		solution.solution(num_list2);
	}
}
