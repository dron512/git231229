package chapter_5;
class ArrayEx4 {
	public static void main(String[] args) {
		char[] abc = { 'A', 'B', 'C', 'D'};
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc);
		System.out.println(num);

		// �迭 abc�� num�� �ٿ��� �ϳ��� �迭(result)�� �����.
		char[] result = new char[abc.length+num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);

		// �迭 abc�� �迭 num�� ù ��° ��ġ���� �迭 abc�� ���̸�ŭ ����
		System.arraycopy(abc, 0, num, 0, abc.length);	
		System.out.println(num);

	     // number�� �ε���6 ��ġ�� 3���� ����
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
	}
}
