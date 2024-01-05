package chap03;
class OperatorEx24 {
	// 문자는 유니코드로 변경 되기 때문에 < > <= >= 됩니다.
	// 문자열은 유니코드로 변경 안되기 때문에 안됩니다.
	public static void main(String args[]) { 
		
		String a = "abc";
		String b = "bde";
		
		int  x = 0;
		char ch = ' ';

		x = 15;
		System.out.printf("x=%2d, 10 < x && x < 20 =%b\n", x, 10 < x && x < 20);

		x = 6;
		System.out.printf("x=%2d,  x%%2==0 || x%%3==0  && x%%6 != 0 =%b\n", x, x%2==0||x%3==0&&x%6!=0);
		System.out.printf("x=%2d, (x%%2==0 || x%%3==0) && x%%6 != 0 =%b\n", x,(x%2==0||x%3==0)&&x%6!=0);

		ch='1';
		System.out.printf("ch='%c', '0' <= ch && ch <= '9' =%b\n", ch, '0' <= ch && ch <='9');

		ch='a';
		System.out.printf("ch='%c', 'a' <= ch && ch <= 'z' =%b\n", ch, 'a' <= ch && ch <='z');

		ch='A';
		System.out.printf("ch='%c', 'A' <= ch && ch <= 'Z' =%b\n", ch, 'A' <= ch && ch <='Z');

		ch='q';
		System.out.printf("ch='%c', ch=='q' || ch=='Q' =%b\n", ch, ch=='q' || ch=='Q');
	}
}
