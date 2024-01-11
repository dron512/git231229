package ch14;
import java.util.*;

class LambdaEx4 {
	public static void main(String[] args) 	{
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++)
			list.add(i);

		// list�� ��� ��Ҹ� ���
		list.forEach(i->System.out.print(i+","));
		System.out.println();

		// list���� 2 �Ǵ� 3�� ����� �����Ѵ�.
		list.removeIf(x-> x%2==0 || x%3==0);
		System.out.println(list);

		list.replaceAll(i->i*10); // list�� �� ��ҿ� 10�� ���Ѵ�.
		System.out.println(list);

		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		// map�� ��� ��Ҹ� {k,v}�� �������� ����Ѵ�.
		map.forEach((k,v)-> System.out.print("{"+k+","+v+"},"));
		System.out.println();
	}
}
