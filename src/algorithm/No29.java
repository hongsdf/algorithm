package algorithm;

import java.util.Scanner;

public class No29 {
	
	
	static int reverse(int n,int m) {
		int result = 0;
		// 1 , 2 =3
		// 2 , 4 = 2 3 4 9
		// 3 , 5 = 3 4 5
		if(m > n) {
			for(int i = n; i <= m; i++) {
				result += i;
			}
			return result;
		}
		else {
			for(int i = n ; i >= m; i--) {
				result += i;
			}
			return result;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		int answer;
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
//		
//		int n1 = 1;
//		int n2 = 3;
		// 18 = 5 + 6 + 7;
		answer = reverse(n1,n2);
		System.out.println(answer);
	}
}
