package ex07;

/*
 * 문자열 my_string, overwrite_string과 정수 s가 주어집니다.
 * 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을
 * 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
	"He11oWor1d"		"lloWorl"	2	"HelloWorld"
	"Program29b8UYP"	"merS123"	7	"ProgrammerS123"
 */
public class Ex01 {
	
	public static String solution(String my_string,
								  String overwrite_string,
								  int s) {
		String temp = my_string.substring(0, s) + overwrite_string;
		String result = my_string.substring(0, s) + overwrite_string + my_string.substring(temp.length());
		return result;
	}
	
	public static void main(String[] args) {
		String result = solution("He11oWor1d", "lloWorl", 2);
		System.out.println(result);

		result = solution("Program29b8UYP", "merS123", 7);
		System.out.println(result);
	}
}
