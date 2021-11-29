package com.study.java.version.v10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers = new ArrayList<Integer>();
		
		// copyOf()
		List<Integer> copyedNumbers1 = List.copyOf(numbers);
		copyedNumbers1.add(1); // throw java.lang.UnsupportedOperationException
		
		// toUnmodifiable
		List<Integer> copyedNumbers2 = numbers.stream().collect(Collectors.toUnmodifiableList());
		copyedNumbers2.add(1); // throw java.lang.UnsupportedOperationException
	}

}
