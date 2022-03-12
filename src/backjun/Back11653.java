package backjun;

import java.util.Scanner;
import java.math.*;
public class Back11653 {
	static void primeDiv(int n){
		
		

//		for(int i =2; i<n; i++) { // 7 :2~6
//			while(n % i ==0) {
//				System.out.println(i+" ");
//				n = n/i; // 24/2
//			}
//			
//		}
		
		for(int i =2; i<= Math.sqrt(n); i++) { // 소수찾기 문제 : Math.sqrt(n)
			while(n%i == 0) {
				System.out.println(i);
				n = n/i;
			}
		}
		if( n!=1) {
			System.out.println(n); // 소수이면 자기자신
		}
			
		
		

	}	
	public static void main(String[] args) {
		// 소인수 분해 24 : 3 * 2 ^ 3
		
		// 2  ~ 3,4,5 ... 소수 
		// 635 : 5 * 127
		// 225 : 5 * 5 * 3 * 3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		primeDiv(n);
		sc.close();
	}
}
