package introduction;

public class vowlDel {
	public static void main(String[] args) {
		// a = 97, e = 101, i = 105, o = 111, u = 117
		String my_string = "nice to meet you";
		String answer = "";
		char[] my_string_arr = my_string.toCharArray();
		char[] result_arr = new char [my_string.length()];
		int index = 0;
		
		for(int i = 0; i < my_string_arr.length; i++) {
			if(my_string_arr[i] != 97 && 
			   my_string_arr[i] != 101 && 
			   my_string_arr[i] != 105 && 
			   my_string_arr[i] != 111 && 
			   my_string_arr[i] != 117) {
				result_arr[index++] += (char)my_string_arr[i];
			}
		}
		answer = String.valueOf(result_arr);
		System.out.println(answer.trim()); // 빈공백 없애주기
	}
}
