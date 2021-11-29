package study.java.v10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudyNewFileMethods {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Path filePath = Files.writeString(Files.createTempFile(Paths.get("./"), "demo", ".txt"), "Sample text");
		String fileContent = Files.readString(filePath);
		System.out.println(fileContent);
	}

}
