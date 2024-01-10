package ex08;

/*
 * 길이가 같은 두 문자열 str1과 str2가 주어집니다.
	두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서
	한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
 * 
 * length()
 * split()
 * subString()
 */

public class Ex01 {

	public static void main(String[] args) {
		String answer="";
		String a = "aaaaa";
		String b = "bbbbb";
		char [] ac = a.toCharArray();
		char [] bc = b.toCharArray();
		
		int [] ints = {1,2,3,4,5,6,7}; 
		for(int i =0; i<ac.length; i++) {
			//ac[0] ac[1] ac[2]...ac[5]
			System.out.print(ac[i]);
			//bc[0] bc[1] bc[2]...bc[5]
			System.out.print(bc[i]);
			answer = answer+ac[i]+bc[i];
		}
		System.out.println();
		System.out.println("answer = "+answer);
	}
	
}
