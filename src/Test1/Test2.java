package Test1;

import java.util.Arrays;

public class Test2 {
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4,5};
		int brr[] = Arrays.copyOf(arr, 4); // 1,2,3,4
		int crr[] = Arrays.copyOfRange(arr, 1,4); // 2,3,4
		
		
	}
}
