package chapter_5;
class ArrayEx14 {
	public static void main(String[] args) {
		String src = "ABCDE";

		for(int i=0; i < src.length(); i++) {
			char ch = src.charAt(i); // src�� i��° ���ڸ� ch�� ����
			System.out.println("src.charAt("+i+"):"+ ch);
		}

		char[] chArr = src.toCharArray();  // String�� char[]�� ��ȯ

		System.out.println(chArr); // char�迭(char[])�� ���
	}
}
