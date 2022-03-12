package algorithm;

import java.util.Scanner;

public class Recursive {
	
//	static int n;
//	static int arr[][] = new int[100][100];
	
	static int Fac(int n) { // stack °³³ä
		// 3! = 3 * 2 * 1
		if(n == 0) {
			return 1;
		}
		
		return n * Fac(n-1);
	}
	
	static int pibo(int n) {
		if(n == 1) return 1;
		if(n == 2) return 1;
		
		
		return pibo(n-1) + pibo(n-2);
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
//		int ans = Fac(n);
		int ans = pibo(n);
		System.out.println(ans);
//		
//		for(int i =0; i <n; i++) {
//			for(int j = 0; j<n; j++) {
//				
//			}
//		}
		
	}

}
