package chapter_5;
class ArrayEx12 {
	public static void main(String[] args) {
		String[] names = {"Kim", "Park", "Yi"};

		for(int i=0; i < names.length;i++) {
			System.out.println("names["+i+"]:"+names[i]);
		}

		String tmp = names[2]; // �迭 names�� �� ��°��Ҹ� tmp�� ����
		System.out.println("tmp:"+tmp);

		names[0] = "Yu"; // �迭 names�� ù ��° ��Ҹ� "Yu"�� ����

		for(String str : names)   // ���� for��
			System.out.println(str);
	} // main
}
