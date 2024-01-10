package ex08;

public class Ex06 {

	public static void doA(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		int answer = 0;

		String ineq = ">";
		String eq = "=";

		int n = 20, m = 50;
		
		if (ineq.equals(">") && eq.equals("="))
			answer = n >= m ? 1 : 0;
		else if (ineq.equals("<") && eq.equals("="))
			answer = n <= m ? 1 : 0;
		else if (ineq.equals(">") && eq.equals("!"))
			answer = n > m ? 1 : 0;
		else if (ineq.equals("<") && eq.equals("!"))
			answer = n < m ? 1 : 0;

		System.out.println(answer);
	}
}
