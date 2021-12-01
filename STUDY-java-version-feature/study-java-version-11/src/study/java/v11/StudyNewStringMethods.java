package study.java.v11;

import java.util.List;
import java.util.stream.Collectors;

public class StudyNewStringMethods {
	public static void main(String[] args) {
		// repeat
		String laWord = "La ";
		String landWord = "Land";
		System.out.println(laWord.repeat(2) + landWord);

		// strip
		String helloWorldWithWhiteSpace = "\n    \t Hello World    \n \u2005";
		System.out.println(helloWorldWithWhiteSpace);
		System.out.println(helloWorldWithWhiteSpace.strip());
		System.out.println(helloWorldWithWhiteSpace.trim());

		// isBlank
		String whiteSpace = "\n\t";
		System.out.println(whiteSpace.isBlank());
		System.out.println(whiteSpace.isEmpty());

		// lines
		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> nonBlankLineList = multilineString.lines().filter(line -> !line.isBlank()).map(String::strip).collect(Collectors.toList());
		System.out.println(nonBlankLineList);
	}
}
