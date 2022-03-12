package backjun;

import java.util.Scanner;

// black ¿Ë
public class Back2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int card = sc.nextInt();
		int goal = sc.nextInt();
		int arr[] = new int[card];
		for(int i =0; i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
//		int n = 3;
//		while(n -->0) {
			int sum = 0; int max = Integer.MIN_VALUE; 
			for(int i =0; i<arr.length-2; i++) {
				for(int j=1; j<arr.length-1; j++) {
					if(arr[i] != arr[j]) {
					for(int k =2; k <arr.length; k++) {
						if(arr[j] != arr[k]  && arr[i] !=arr[k] ) {
//						5 21
//						5 6 7 8 9  => 1. 5 6 7   =>   2. 6 7 8   => 7 8 9
						sum = arr[i] + arr[j] +arr[k]; //  5  +    6*(1)  , 7*(2), 8    +  7,8,9
						
						if(sum <= goal) {
							if(sum > max) {
								max = sum;
							}
							
						}
						

					}
				}
			}
		}
	}
//			if(ans == goal) System.out.println(goal);
			 System.out.println(max);
		
				
			
		
		
	}
}
