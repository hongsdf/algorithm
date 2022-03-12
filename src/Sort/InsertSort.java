package Sort;
import java.util.*;
public class InsertSort {
	public static void main(String[] args) {
		List<Integer> arr1 = new ArrayList<>(Arrays.asList(5,3,1));
		int arr[] = new int[3];
		arr[0] = 5;
		arr[1] = 3;
		arr[2] = 1;
//		System.out.println(arr.length);
//		insert(arr);
		insert2(arr1);
	}

	public static void insert(int[] arr) {
		int j;
		for(int i =1; i <arr.length; i++) { // 1 //2
			j = i-1;
			while(arr[j] > arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
				if(j<0) break;
			}
		}
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	// List 
	public static void insert2(List<Integer> arr1) {
		int j;
		for(int i =1; i <arr1.size(); i++) { // 1 //2
			j = i-1;
			while(arr1.get(j) > arr1.get(j+1)) {
				int temp = arr1.get(j);
				arr1.set(j , arr1.get(j+1));
				arr1.set(j+1, temp);
				j--;
				if(j<0) break;
			}
		}
		for(int i =0; i<arr1.size(); i++) {
			System.out.print(arr1.get(i)+" ");
		}
		
	}
}
