package study.java.v10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudyLocalVarForLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sampleList = Arrays.asList("Java", "Kotlin");
		String resultString = sampleList.stream()
		  .map((var x) -> x.toUpperCase())
		  .collect(Collectors.joining(", "));
		System.out.println(resultString);
	}

}
