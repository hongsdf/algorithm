package datastructure;

import java.util.*;

public class Datastructure_2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		List<List<Integer>> arr = new ArrayList<>();
		int arr[][] = new int[6][6];
		int max = Integer.MIN_VALUE;
		for(int i=0; i <6;i++) {
			for(int j=0; j<6; j++) {
				arr[i][j] = sc.nextInt();
			}
			
		}
		int sum = 0;
		for(int i = 0; i <arr.length; i++) {
			for(int j =0; j <arr[i].length;j++) {
				if(i > 0 && i < arr.length-1 && j > 0 && j < arr[i].length-1) {
				sum = arr[i][j] + 
					  arr[i-1][j] + arr[i-1][j-1] + arr[i-1][j+1]+ 
					  arr[i+1][j] + arr[i+1][j-1] + arr[i+1][j+1];
				if(sum > max) {
					max = sum;
				}

				}
				
			}
		}
		System.out.print(max);
		
		
	}
}
