package ex07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exam {

	public static void main(String[] args) {
		List list = Arrays.asList("12","34","56","78","aaa","aab","aac");
		System.out.println(list);
		
		list.stream()
		.filter( s-> ((String)s).contains("a"))
		.forEach(s->System.out.println(s));
		
		List list1 = (List) list.stream()
		.filter( s-> ((String)s).contains("a"))
		.collect(Collectors.toList());
		
		System.out.println(list1);
		
		
	}
}
