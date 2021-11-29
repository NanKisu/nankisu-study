package study.java.v10;

import java.util.Arrays;
import java.util.List;

public class StudyToArray {
	public static void main(String[] args) {
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String[] sampleArray = sampleList.toArray(String[]::new);
	}
}
