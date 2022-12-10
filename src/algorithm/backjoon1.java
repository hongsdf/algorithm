package algorithm;

import java.util.Scanner;

public class backjoon1 {
	 
		// n  ,  k
		// 10 ,  3  == 14
	    // 10 + (10/3 == 3) + (3/3 == 1) = 14
	
		// 100 + 100/5 == 20 + 20/5 == 4
	
//		static void kitchen(int n,int k) {
//			int cnt = 0;
//			int n3 = 0;
//			cnt = n + (n/k);
//			n = n/k;
//			n3  = n/k;
//			cnt += n3;
//			System.out.println(cnt);
//			return;
//		}
	
	static int kitchen(int n,int k) {
		int result = 0;
		if(n >= k ) { // 10, 3 = 3,3 // ���� ��� ���� Ȯ�� (n >= k )
			if(n/k >= 1) { // 3 >= 1, 1 >=1
				result =  n + kitchen(n/k,k); // 10 + 3 + 1
				
			}
			return result;
			
		}else 
			return result += n;
		
		// 1000,5 : 1000 + 200 + 40 + 8 + 1 = 1249
		// 100,5 : 100 + 20 + 4
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		int answer = 0;
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		
		answer = kitchen(n,k);
		System.out.println(answer);
	}
}
