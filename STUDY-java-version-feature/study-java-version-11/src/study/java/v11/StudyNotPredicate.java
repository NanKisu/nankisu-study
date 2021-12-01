package study.java.v11;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudyNotPredicate {
	public static void main(String[] args) {
		String multilineString = "Baeldung helps \n \n developers \n explore Java.";
		List<String> nonBlankLineList = multilineString.lines()
		  .filter(Predicate.not(String::isBlank))  // filter(line -> !line.isBlank()) 대신 사용
		  .map(String::strip)
		  .collect(Collectors.toList());
	}
}
