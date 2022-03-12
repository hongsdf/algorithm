package backjun;

import java.util.Scanner;

public class Back10872 {
	static int pibo(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(n == 2) return 1;

		return pibo(n-1) + pibo(n-2);
		// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = pibo(n);
		System.out.print(ans);
		
	}
}
