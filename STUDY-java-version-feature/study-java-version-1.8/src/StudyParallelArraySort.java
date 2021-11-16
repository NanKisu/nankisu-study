import java.util.Arrays;

public class StudyParallelArraySort {
	private static final int length = 10000000;
	
	public static void main(String[] args) {
		int[] intList = new int[length];
		for(int i = 0; i < length; i++) {
			intList[i] = (int)(Math.random() * Integer.MAX_VALUE);
		}
		
		long start = System.currentTimeMillis();
		//Arrays.sort(intList);
		Arrays.parallelSort(intList);
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
	}
}
