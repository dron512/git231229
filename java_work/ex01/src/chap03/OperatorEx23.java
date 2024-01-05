package chap03;

/*
 * 클래스는... 메서드로... 이루어져있습니다..
 * 
 * 메서드 
 * int a = 10;
 * system.out.println();
 * 수행문으로 이루어져있습니다.
 */

class AA{
	public void doA() {
		int a= 10;
		System.out.println("a = "+a++);
	}
}
class OperatorEx23 {
	public static void main(String[] args) {
		AA aa1 = new AA();
		aa1.doA();
		aa1.doA();
		
		String str1 = "abc";
		String str2 = new String("abc");

		System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc"=="abc");
		System.out.printf(" str1==\"abc\" ? %b%n",    str1=="abc");
		System.out.printf(" str2==\"abc\" ? %b%n",    str2=="abc");
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc"));
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));
		System.out.printf("str2.equals(\"ABC\") ? %b%n", str2.equals("ABC"));
		System.out.printf("str2.equalsIgnoreCase(\"ABC\") ? %b%n", str2.equalsIgnoreCase("ABC"));
	}
}
