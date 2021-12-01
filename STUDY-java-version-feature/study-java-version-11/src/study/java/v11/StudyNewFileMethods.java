package study.java.v11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudyNewFileMethods {

	public static void main(String[] args) throws IOException {
		Path filePath = Files.writeString(Files.createTempFile("test_", ".txt"), "Sample text");
		String fileContent = Files.readString(filePath);
		System.out.println(filePath.toFile().getAbsolutePath());
		System.out.println(fileContent);
	}

}
