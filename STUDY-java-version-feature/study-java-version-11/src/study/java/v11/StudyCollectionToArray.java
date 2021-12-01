package study.java.v11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudyCollectionToArray {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		String[] names_array = names.toArray(String[]::new);
	}
}
