package datastructure;

import java.util.Scanner;

public class DataStructure_subArray {
	/* SubArray ¹®Á¦ */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i =0; i <arr.length;i++) {
			arr[i] = sc.nextInt();
		}
//		for(int i =0; i <arr.length;i++) {
//			System.out.print(arr[i]+" ");
//		}
		int sum = 0;
		for(int i=0; i<arr.length;i++) { 
			sum = 0;
			for(int j=i; j<arr.length; j++) {
				sum +=arr[j]; // 2, 2-2 , 0 + 4, 4-5, -1 + 1
				if(sum < 0) { 
					cnt++;
				}
				
			}
		}
		System.out.println(cnt);
	}
}
