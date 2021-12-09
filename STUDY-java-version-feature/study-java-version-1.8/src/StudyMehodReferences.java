import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudyMehodReferences {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(0);
		intList.add(1);
		intList.add(2);
		//List<List<Integer>> resultList = intList.stream().map(Arrays::asList).collect(Collectors.toList());
		//List<Integer> resultList = intList.stream().map(intList::get).collect(Collectors.toList());
		List<Double> resultList = intList.stream().map(Double::new).collect(Collectors.toList());
		System.out.println(intList);
		System.out.println(resultList);
	}
}
