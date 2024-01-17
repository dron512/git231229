package ex11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex13 {

	public static void main(String[] args) throws IOException {
		Stream<String> stream = Files.lines(Paths.get("src/a.txt"));
//		stream.forEach(System.out::println);

		List<Integer> list = stream.mapToInt(String::length).boxed().collect(Collectors.toList());
		System.out.println(list);
	}
}
