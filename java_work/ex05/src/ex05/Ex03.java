package ex05;

public class Ex03 {

	public static void main(String[] args) {
	
		char a = 'a';
		
		for(int i =0; i<26;i++) {
			System.out.println(i+"\t"+a++);
		}
		
		a = 'A';
		
		for(int i =0; i<26;i++) {
			System.out.println(i+"\t"+a++);
		}
		
		a = '0';
		System.out.println((int)a);
		
		int b = 0;
		
		for(int i =0; i<26;i++) {
			System.out.println(i+"\t"+a++);
		}
		
	}
	
}
