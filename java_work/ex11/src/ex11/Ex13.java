package ex11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Ex13 {

	public static void main(String[] args) throws IOException {
		Stream<String> stream = Files.lines(Paths.get("src/a.txt"));
		stream.forEach(System.out::println);
	}
}
