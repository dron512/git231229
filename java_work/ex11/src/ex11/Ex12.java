package ex11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex12 {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/a.txt");
		
		String content="안녕하세요";
		
		Files.write(path, content.getBytes());
	}
}
