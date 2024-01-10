package chapter_5;
class ArrayEx6 { 
	public static void main(String[] args) { 
		int[] score = { 79, 88, 91, 33, 100, 55, 95}; 

		int max = score[0]; // �迭�� ù ��° ������ �ִ밪�� �ʱ�ȭ �Ѵ�. 
		int min = score[0]; // �迭�� ù ��° ������ �ּҰ��� �ʱ�ȭ �Ѵ�. 

		for(int i=1; i < score.length;i++) {
			if(score[i] > max) { 
				max = score[i]; 
			} else if(score[i] < min) { 
				min = score[i]; 
			} 
		} // end of for 

		System.out.println("�ִ밪 :" + max);       
		System.out.println("�ּҰ� :" + min);       
	} // end of main 
} // end of class 
