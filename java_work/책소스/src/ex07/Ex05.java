package ex07;

/*
 *  
 */
public class Ex05 {

	public static String solution(String my_string, int k) {
		System.out.println(my_string);
		System.out.println(k);
		
		String answer = "";
		// i = 0, i = 1, i = 2 
		for(int i =0; i<k ;i++)
			answer = answer+ my_string;
		
		return answer;
	}

	public static void main(String[] args) {
		String result = solution("string", 3);
		System.out.println("result = "+result);
		result = solution("love",10);
		System.out.println("result = "+result);

	}
}
