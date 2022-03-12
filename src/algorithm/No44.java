package algorithm;

import java.util.Scanner;

public class No44 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[1000];
		int up[] = new int [1001];
		int d[] = new int [1001];
		// 1 2 3
		for(int i =1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i =1; i<=n; i++) {
			up[i] = 1;
			d[i] =1;
		}
		
		/*                              
		 *      1  2  3  4  5  6  7  8  9  10  // arr[i] > arr[j] 
		 *      1  5  2  1  4  3  4  5  2  1   //   2    >  2
		 * dpH  1  2  2  1  3  3  4  5  2  1   //  arr[i] > arr[j]               
		 * dpL  1  4  2  1  4  3  3  3  2  1 //   2    >  1
		 *      2  6  4  2  7  6  7  8  4  2   //   5 > 5
		 *      							   //   5 > 2
		 *      							   //   5 > 1
		 *      							   
		 *      
		 */
		
		
		
		//  8
	 // idx 0 1 2 3 4 5 6 7
		
		//  1 2 5 6 4 3 2 1
//		d   4 3 2 1 1 1 1 1
//		up  1 2 3 4 3 3 2 1
		
		for(int i = 2; i<=n; i++) { // 1 ~ 
			for(int j = i; j>=1; j--) {
				if(arr[i] > arr[j]) 
					up[i] = max(up[i],arr[j]+1);
			}
		}
		// 9 
		for(int j = n-1; j >=1; j--) {
			for(int i = j; i<=n;i++ ) {
			if(arr[i] < arr[j]) {
				d[j] = max(d[j],arr[i]+1); // arr[9] 1 = 1, arr[9] : 1 +1  //arr[8] = 3, arr[9]+1 : 3 || arr[10] +1 :2
				}
			}
		}
		
//		for (int i = cnt - 1; i >= 1; i--) {
//			for (int j = i; j <= cnt; j++) {
//				if (input[j] < input[i]) {
//					dpL[i] = getMax(dpL[i], dpL[j] + 1);
//				} 	
//			}
//		}
		
		
		
		
		for(int i =1; i<=n; i++) {
			System.out.print(up[i]+" ");
		}
		System.out.println();
		for(int i =1; i<=n; i++) {
			System.out.print(d[i]+" ");
		}
		
		int max = 0;
		for(int i = 1; i<=n; i++) {
			if( max < up[i] + d[i]) {
				max = up[i] + d[i];
			}
			
		}
		System.out.println(max-1);
	}	
		
		
		/*
		 * for (int i = 2; i <= cnt; i++) {
			for (int j = i; j >= 1; j--) {
				if (input[j] < input[i]) {   5 < 5, 2 < 5,1<5 
					dpH[i] = getMax(dpH[i], dpH[j] + 1);
					1  =   1,1+2 || 1+ 1 3,2
				} 	
			}
		}
		 * */
		
		
		
		
	
	private static int max(int i, int j) {
		if( i >j) return i;
		else return j;
	}
}
	
	