package backjun;

import java.util.Scanner;

public class Back1978 {
	static boolean prime(int n) {
		boolean flag = true; //소수 :  true, 소수x : false
		
		if(n==1) return false;
		if(n==2) flag = true;
		
		for(int i=2; i<n; i++){
			if(n%i == 0) {
				flag = false;
			}

		}
		
		return flag;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int m =sc.nextInt();
		int min = Integer.MAX_VALUE;
		// 25개
		// 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
		// 41, 43, 47, 53, 59,
		// 61, 67, 71, 73, 79, 83, 89, 97
		int arr[] = new int[100];
		int sum = 0;
		// 60 ~ 100
		for(int i=n; i <= m;i++) {
			if(prime(i) == true) {
//				System.out.println(i);
				if(i < min) {
					min = i;
				}
				sum += i;
				
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(min);
		}
		
	
		
		
			
		sc.close();
		

	}

}
