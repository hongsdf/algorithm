package datastructure;

import java.util.Scanner;

public class DataStructure_SubArray2 {
	/*Input: nums = [5,4,-1,7,8] Output: 23 */
	static int max(int arr[]) {
		int sum = 0;
		int Max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			sum =0;
			for(int j =i; j <arr.length; j++) {
				sum += arr[j];
				if(sum > Max) Max = sum; 
			}
			
		}
		
		return Max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		int arr[] = new int[nums];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
//		for(int i=0; i<arr.length; i++) {
//			System.out.print( arr[i] +" ");
//		}
		
		int ans = max(arr);
		System.out.println(ans);
		
		
	
	}
}
